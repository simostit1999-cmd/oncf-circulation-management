package demo.reactAdmin.oncf.repository;

import demo.reactAdmin.oncf.entity.Control;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ControlRepository extends JpaRepository<Control, Long> {
    // Ici on pourra ajouter des méthodes de recherche spécifiques plus tard
}
