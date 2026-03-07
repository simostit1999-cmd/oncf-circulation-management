package demo.reactAdmin.oncf.service;

import demo.reactAdmin.oncf.entity.AnalyseRisque;
import demo.reactAdmin.oncf.repository.AnalyseRisqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnalyseRisqueService {

    @Autowired
    private AnalyseRisqueRepository repository;

    // Créer ou mettre à jour une analyse de risque
    public AnalyseRisque saveAnalyse(AnalyseRisque analyse) {
        return repository.save(analyse);
    }

    // Lister toutes les analyses
    public List<AnalyseRisque> getAllAnalyses() {
        return repository.findAll();
    }

    // Chercher une analyse par ID
    public Optional<AnalyseRisque> getAnalyseById(Long id) {
        return repository.findById(id);
    }

    // Supprimer une analyse
    public void deleteAnalyse(Long id) {
        repository.deleteById(id);
    }
}
