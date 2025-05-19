package ma.elboubkari.soufiane.repositories;

import ma.elboubkari.soufiane.entities.CreditPersonnel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreditPersonnelRepository extends JpaRepository<CreditPersonnel, Long> {
    // Recherche par motif
    List<CreditPersonnel> findByMotifContainsIgnoreCase(String motif);
}
