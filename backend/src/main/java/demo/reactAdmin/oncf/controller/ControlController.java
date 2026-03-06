package demo.reactAdmin.oncf.controller;

import demo.reactAdmin.oncf.entity.Control;
import demo.reactAdmin.oncf.service.ControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/controls")
public class ControlController {

    @Autowired
    private ControlService controlService;

    private final String uploadDir = "uploads/controls/"; // dossier local pour fichiers

    // Lister tous les contrôles
    @GetMapping
    public List<Control> getAllControls() {
        return controlService.getAllControls();
    }

    // Chercher un contrôle par ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getControl(@PathVariable Long id) {
        Optional<Control> control = controlService.getControlById(id);
        return control.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    // Créer un contrôle avec upload de fichier
    @PostMapping
    public ResponseEntity<?> createControl(@RequestPart("control") Control control,
                                           @RequestPart(value = "file", required = false) MultipartFile file) throws IOException {
        // gérer le fichier si présent
        if (file != null && !file.isEmpty()) {
            File dir = new File(uploadDir);
            if (!dir.exists()) dir.mkdirs();

            String filePath = uploadDir + System.currentTimeMillis() + "_" + file.getOriginalFilename();
            file.transferTo(new File(filePath));
            control.setFichierJoint(filePath);
        }

        Control saved = controlService.saveControl(control);
        return ResponseEntity.ok(saved);
    }

    // Mettre à jour un contrôle
    @PutMapping("/{id}")
    public ResponseEntity<?> updateControl(@PathVariable Long id,
                                           @RequestBody Control controlDetails) {
        Optional<Control> optionalControl = controlService.getControlById(id);
        if (optionalControl.isEmpty()) return ResponseEntity.notFound().build();

        Control control = optionalControl.get();
        control.setDateControl(controlDetails.getDateControl());
        control.setSite(controlDetails.getSite());
        control.setAgent(controlDetails.getAgent());
        control.setTypeControle(controlDetails.getTypeControle());
        control.setResultat(controlDetails.getResultat());
        control.setObservations(controlDetails.getObservations());
        control.setActionMenee(controlDetails.getActionMenee());

        Control updated = controlService.saveControl(control);
        return ResponseEntity.ok(updated);
    }

    // Supprimer un contrôle
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteControl(@PathVariable Long id) {
        controlService.deleteControl(id);
        return ResponseEntity.ok().build();
    }
}
