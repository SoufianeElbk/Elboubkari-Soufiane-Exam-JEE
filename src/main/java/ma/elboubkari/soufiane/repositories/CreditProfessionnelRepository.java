package ma.elboubkari.soufiane.repositories;

import ma.elboubkari.soufiane.entities.CreditProfessionnel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreditProfessionnelRepository extends JpaRepository<CreditProfessionnel, Long> {
    List<CreditProfessionnel> findByRaisonSocialeContainsIgnoreCase(String raisonSociale);

    List<CreditProfessionnel> findByMotifContainsIgnoreCase(String motif);
}