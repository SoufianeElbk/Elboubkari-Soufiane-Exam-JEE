package ma.elboubkari.soufiane.repositories;

import ma.elboubkari.soufiane.entities.Remboursement;
import ma.elboubkari.soufiane.enums.TypeRemboursement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface RemboursementRepository extends JpaRepository<Remboursement, Long> {
    // Recherche par crédit
    List<Remboursement> findByCreditId(Long creditId);

    // Recherche par type de remboursement
    List<Remboursement> findByType(TypeRemboursement type);

    // Recherche par date
    List<Remboursement> findByDateAfter(Date date);

    // Recherche par montant supérieur à
    List<Remboursement> findByMontantGreaterThan(Double montant);
}
