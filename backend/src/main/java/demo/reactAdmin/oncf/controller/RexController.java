package demo.reactAdmin.oncf.controller;

import demo.reactAdmin.oncf.entity.Rex;
import demo.reactAdmin.oncf.service.RexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rex")
public class RexController {

    @Autowired
    private RexService rexService;

    private final String uploadDir = "uploads/rex/"; // dossier local pour fichiers

    // Lister tous les REX
    @GetMapping
    public List<Rex> getAllRex() {
        return rexService.getAllRex();
    }

    // Chercher un REX par ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getRex(@PathVariable Long id) {
        Optional<Rex> rex = rexService.getRexById(id);
        return rex.map(ResponseEntity::ok)
                  .orElse(ResponseEntity.notFound().build());
    }

    // Créer un REX avec upload de fichier
    @PostMapping
    public ResponseEntity<?> createRex(@RequestPart("rex") Rex rex,
                                       @RequestPart(value = "file", required = false) MultipartFile file) throws IOException {
        if (file != null && !file.isEmpty()) {
            File dir = new File(uploadDir);
            if (!dir.exists()) dir.mkdirs();

            String filePath = uploadDir + System.currentTimeMillis() + "_" + file.getOriginalFilename();
            file.transferTo(new File(filePath));
            rex.setFichierJoint(filePath);
        }

        Rex saved = rexService.saveRex(rex);
        return ResponseEntity.ok(saved);
    }

    // Mettre à jour un REX
    @PutMapping("/{id}")
    public ResponseEntity<?> updateRex(@PathVariable Long id,
                                       @RequestBody Rex rexDetails) {
        Optional<Rex> optionalRex = rexService.getRexById(id);
        if (optionalRex.isEmpty()) return ResponseEntity.notFound().build();

        Rex rex = optionalRex.get();
        rex.setDateEvenement(rexDetails.getDateEvenement());
        rex.setNature(rexDetails.getNature());
        rex.setGravite(rexDetails.getGravite());
        rex.setCauses(rexDetails.getCauses());
        rex.setActionsDecidees(rexDetails.getActionsDecidees());

        Rex updated = rexService.saveRex(rex);
        return ResponseEntity.ok(updated);
    }

    // Supprimer un REX
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRex(@PathVariable Long id) {
        rexService.deleteRex(id);
        return ResponseEntity.ok().build();
    }
}
