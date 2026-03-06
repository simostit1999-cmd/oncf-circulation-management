package demo.reactAdmin.oncf.repository;

import demo.reactAdmin.oncf.entity.ActionCorrective;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionCorrectiveRepository extends JpaRepository<ActionCorrective, Long> {
    // Méthodes de recherche spécifiques pourront être ajoutées plus tard
}
