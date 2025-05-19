package ma.elboubkari.soufiane.repositories;

import ma.elboubkari.soufiane.entities.Remboursement;
import ma.elboubkari.soufiane.enums.TypeRemboursement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface RemboursementRepository extends JpaRepository<Remboursement, Long> {
    List<Remboursement> findByCreditId(Long creditId);

    List<Remboursement> findByType(TypeRemboursement type);

    List<Remboursement> findByDateAfter(Date date);

    List<Remboursement> findByMontantGreaterThan(Double montant);
}
