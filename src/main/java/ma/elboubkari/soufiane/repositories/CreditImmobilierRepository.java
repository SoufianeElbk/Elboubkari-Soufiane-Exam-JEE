package ma.elboubkari.soufiane.repositories;

import ma.elboubkari.soufiane.entities.CreditImmobilier;
import ma.elboubkari.soufiane.enums.TypeBien;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreditImmobilierRepository extends JpaRepository<CreditImmobilier, Long> {
    List<CreditImmobilier> findByTypeBien(TypeBien typeBien);
}
