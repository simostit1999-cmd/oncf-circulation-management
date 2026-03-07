package demo.reactAdmin.oncf.controller;

import demo.reactAdmin.oncf.entity.Personnel;
import demo.reactAdmin.oncf.service.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/personnel")
public class PersonnelController {

    @Autowired
    private PersonnelService personnelService;

    // Lister tout le personnel
    @GetMapping
    public List<Personnel> getAllPersonnel() {
        return personnelService.getAllPersonnel();
    }

    // Chercher un personnel par ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getPersonnel(@PathVariable Long id) {
        Optional<Personnel> personnel = personnelService.getPersonnelById(id);
        return personnel.map(ResponseEntity::ok)
                        .orElse(ResponseEntity.notFound().build());
    }

    // Créer un personnel
    @PostMapping
    public ResponseEntity<?> createPersonnel(@RequestBody Personnel personnel) {
        Personnel saved = personnelService.savePersonnel(personnel);
        return ResponseEntity.ok(saved);
    }

    // Mettre à jour un personnel
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePersonnel(@PathVariable Long id,
                                             @RequestBody Personnel personnelDetails) {
        Optional<Personnel> optionalPersonnel = personnelService.getPersonnelById(id);
        if (optionalPersonnel.isEmpty()) return ResponseEntity.notFound().build();

        Personnel personnel = optionalPersonnel.get();
        personnel.setNom(personnelDetails.getNom());
        personnel.setPrenom(personnelDetails.getPrenom());
        personnel.setMatricule(personnelDetails.getMatricule());
        personnel.setFonction(personnelDetails.getFonction());
        personnel.setFormations(personnelDetails.getFormations());
        personnel.setHabilitations(personnelDetails.getHabilitations());
        personnel.setEvaluations(personnelDetails.getEvaluations());
        personnel.setConges(personnelDetails.getConges());

        Personnel updated = personnelService.savePersonnel(personnel);
        return ResponseEntity.ok(updated);
    }

    // Supprimer un personnel
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePersonnel(@PathVariable Long id) {
        personnelService.deletePersonnel(id);
        return ResponseEntity.ok().build();
    }
}
