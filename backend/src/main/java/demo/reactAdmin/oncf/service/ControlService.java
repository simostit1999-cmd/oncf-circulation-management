package demo.reactAdmin.oncf.service;

import demo.reactAdmin.oncf.entity.Control;
import demo.reactAdmin.oncf.repository.ControlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ControlService {

    @Autowired
    private ControlRepository controlRepository;

    // Créer ou mettre à jour un contrôle
    public Control saveControl(Control control) {
        return controlRepository.save(control);
    }

    // Lister tous les contrôles
    public List<Control> getAllControls() {
        return controlRepository.findAll();
    }

    // Chercher un contrôle par ID
    public Optional<Control> getControlById(Long id) {
        return controlRepository.findById(id);
    }

    // Supprimer un contrôle
    public void deleteControl(Long id) {
        controlRepository.deleteById(id);
    }
}
