package demo.reactAdmin.oncf.service;

import demo.reactAdmin.oncf.entity.Rex;
import demo.reactAdmin.oncf.repository.RexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RexService {

    @Autowired
    private RexRepository repository;

    // Créer ou mettre à jour un REX
    public Rex saveRex(Rex rex) {
        return repository.save(rex);
    }

    // Lister tous les REX
    public List<Rex> getAllRex() {
        return repository.findAll();
    }

    // Chercher un REX par ID
    public Optional<Rex> getRexById(Long id) {
        return repository.findById(id);
    }

    // Supprimer un REX
    public void deleteRex(Long id) {
        repository.deleteById(id);
    }
}
