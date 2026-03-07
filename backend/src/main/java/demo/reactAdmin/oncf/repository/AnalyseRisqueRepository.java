package demo.reactAdmin.oncf.repository;

import demo.reactAdmin.oncf.entity.AnalyseRisque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalyseRisqueRepository extends JpaRepository<AnalyseRisque, Long> {
    // Méthodes de recherche spécifiques pourront être ajoutées plus tard
}
