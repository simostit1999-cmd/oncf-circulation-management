package demo.reactAdmin.oncf.service;

import demo.reactAdmin.oncf.entity.ActionCorrective;
import demo.reactAdmin.oncf.repository.ActionCorrectiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActionCorrectiveService {

    @Autowired
    private ActionCorrectiveRepository repository;

    // Créer ou mettre à jour une action
    public ActionCorrective saveAction(ActionCorrective action) {
        return repository.save(action);
    }

    // Lister toutes les actions
    public List<ActionCorrective> getAllActions() {
        return repository.findAll();
    }

    // Chercher une action par ID
    public Optional<ActionCorrective> getActionById(Long id) {
        return repository.findById(id);
    }

    // Supprimer une action
    public void deleteAction(Long id) {
        repository.deleteById(id);
    }
}
