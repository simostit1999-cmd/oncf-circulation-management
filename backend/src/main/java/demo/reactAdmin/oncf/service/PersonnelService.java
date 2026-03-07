package demo.reactAdmin.oncf.service;

import demo.reactAdmin.oncf.entity.Personnel;
import demo.reactAdmin.oncf.repository.PersonnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonnelService {

    @Autowired
    private PersonnelRepository repository;

    // Créer ou mettre à jour un personnel
    public Personnel savePersonnel(Personnel personnel) {
        return repository.save(personnel);
    }

    // Lister tout le personnel
    public List<Personnel> getAllPersonnel() {
        return repository.findAll();
    }

    // Chercher un personnel par ID
    public Optional<Personnel> getPersonnelById(Long id) {
        return repository.findById(id);
    }

    // Supprimer un personnel
    public void deletePersonnel(Long id) {
        repository.deleteById(id);
    }
}
