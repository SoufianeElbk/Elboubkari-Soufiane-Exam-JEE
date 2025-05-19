package ma.elboubkari.soufiane.repositories;

import ma.elboubkari.soufiane.entities.CreditProfessionnel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreditProfessionnelRepository extends JpaRepository<CreditProfessionnel, Long> {
    // Recherche par raison sociale
    List<CreditProfessionnel> findByRaisonSocialeContainsIgnoreCase(String raisonSociale);

    // Recherche par motif
    List<CreditProfessionnel> findByMotifContainsIgnoreCase(String motif);
}