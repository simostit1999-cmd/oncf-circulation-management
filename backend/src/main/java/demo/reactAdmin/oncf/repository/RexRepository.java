package demo.reactAdmin.oncf.repository;

import demo.reactAdmin.oncf.entity.Rex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RexRepository extends JpaRepository<Rex, Long> {
    // Méthodes de recherche spécifiques pourront être ajoutées plus tard
}
