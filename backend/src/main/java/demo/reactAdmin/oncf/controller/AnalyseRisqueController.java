package demo.reactAdmin.oncf.controller;

import demo.reactAdmin.oncf.entity.AnalyseRisque;
import demo.reactAdmin.oncf.service.AnalyseRisqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/analyses")
public class AnalyseRisqueController {

    @Autowired
    private AnalyseRisqueService analyseService;

    private final String uploadDir = "uploads/analyses/"; // dossier local pour fichiers

    // Lister toutes les analyses
    @GetMapping
    public List<AnalyseRisque> getAllAnalyses() {
        return analyseService.getAllAnalyses();
    }

    // Chercher une analyse par ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getAnalyse(@PathVariable Long id) {
        Optional<AnalyseRisque> analyse = analyseService.getAnalyseById(id);
        return analyse.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    // Créer une analyse avec upload de fichier
    @PostMapping
    public ResponseEntity<?> createAnalyse(@RequestPart("analyse") AnalyseRisque analyse,
                                           @RequestPart(value = "file", required = false) MultipartFile file) throws IOException {
        if (file != null && !file.isEmpty()) {
            File dir = new File(uploadDir);
            if (!dir.exists()) dir.mkdirs();

            String filePath = uploadDir + System.currentTimeMillis() + "_" + file.getOriginalFilename();
            file.transferTo(new File(filePath));
            analyse.setFichierJoint(filePath);
        }

        AnalyseRisque saved = analyseService.saveAnalyse(analyse);
        return ResponseEntity.ok(saved);
    }

    // Mettre à jour une analyse
    @PutMapping("/{id}")
    public ResponseEntity<?> updateAnalyse(@PathVariable Long id,
                                           @RequestBody AnalyseRisque analyseDetails) {
        Optional<AnalyseRisque> optionalAnalyse = analyseService.getAnalyseById(id);
        if (optionalAnalyse.isEmpty()) return ResponseEntity.notFound().build();

        AnalyseRisque analyse = optionalAnalyse.get();
        analyse.setProcessus(analyseDetails.getProcessus());
        analyse.setDanger(analyseDetails.getDanger());
        analyse.setGravite(analyseDetails.getGravite());
        analyse.setProbabilite(analyseDetails.getProbabilite());
        analyse.setNiveauRisque(analyseDetails.getNiveauRisque());
        analyse.setMesuresMaitrise(analyseDetails.getMesuresMaitrise());

        AnalyseRisque updated = analyseService.saveAnalyse(analyse);
        return ResponseEntity.ok(updated);
    }

    // Supprimer une analyse
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAnalyse(@PathVariable Long id) {
        analyseService.deleteAnalyse(id);
        return ResponseEntity.ok().build();
    }
}
