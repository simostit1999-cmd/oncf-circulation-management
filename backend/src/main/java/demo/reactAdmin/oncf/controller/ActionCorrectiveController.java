package demo.reactAdmin.oncf.controller;

import demo.reactAdmin.oncf.entity.ActionCorrective;
import demo.reactAdmin.oncf.service.ActionCorrectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/actions")
public class ActionCorrectiveController {

    @Autowired
    private ActionCorrectiveService actionService;

    private final String uploadDir = "uploads/actions/"; // dossier local pour fichiers

    // Lister toutes les actions
    @GetMapping
    public List<ActionCorrective> getAllActions() {
        return actionService.getAllActions();
    }

    // Chercher une action par ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getAction(@PathVariable Long id) {
        Optional<ActionCorrective> action = actionService.getActionById(id);
        return action.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }

    // Créer une action avec upload de fichier
    @PostMapping
    public ResponseEntity<?> createAction(@RequestPart("action") ActionCorrective action,
                                          @RequestPart(value = "file", required = false) MultipartFile file) throws IOException {
        // gérer le fichier si présent
        if (file != null && !file.isEmpty()) {
            File dir = new File(uploadDir);
            if (!dir.exists()) dir.mkdirs();

            String filePath = uploadDir + System.currentTimeMillis() + "_" + file.getOriginalFilename();
            file.transferTo(new File(filePath));
            action.setFichierJoint(filePath);
        }

        ActionCorrective saved = actionService.saveAction(action);
        return ResponseEntity.ok(saved);
    }

    // Mettre à jour une action
    @PutMapping("/{id}")
    public ResponseEntity<?> updateAction(@PathVariable Long id,
                                          @RequestBody ActionCorrective actionDetails) {
        Optional<ActionCorrective> optionalAction = actionService.getActionById(id);
        if (optionalAction.isEmpty()) return ResponseEntity.notFound().build();

        ActionCorrective action = optionalAction.get();
        action.setReference(actionDetails.getReference());
        action.setResponsable(actionDetails.getResponsable());
        action.setEcheance(actionDetails.getEcheance());
        action.setStatut(actionDetails.getStatut());
        action.setIndicateur(actionDetails.getIndicateur());
        action.setDescription(actionDetails.getDescription());

        ActionCorrective updated = actionService.saveAction(action);
        return ResponseEntity.ok(updated);
    }

    // Supprimer une action
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAction(@PathVariable Long id) {
        actionService.deleteAction(id);
        return ResponseEntity.ok().build();
    }
}
