package ma.elboubkari.soufiane.repositories;

import ma.elboubkari.soufiane.entities.Credit;
import ma.elboubkari.soufiane.enums.StatutCredit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface CreditRepository extends JpaRepository<Credit, Long> {
    List<Credit> findByStatut(StatutCredit statut);

    List<Credit> findByClientId(Long clientId);

    List<Credit> findByMontantGreaterThan(Double montant);

    List<Credit> findByDateDemandeIsBetween(Date dateDebut, Date dateFin);

    @Query("SELECT c FROM Credit c WHERE TYPE(c) = :type")
    List<Credit> findByType(@Param("type") Class<?> type);
}
