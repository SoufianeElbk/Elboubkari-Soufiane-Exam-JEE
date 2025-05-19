package ma.elboubkari.soufiane.repositories;


import ma.elboubkari.soufiane.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    // Recherche par email
    Client findByEmail(String email);

    // Recherche par nom (partiel)
    List<Client> findByNomContainsIgnoreCase(String nom);

    // Recherche des clients ayant au moins un crédit
    @Query("SELECT DISTINCT c FROM Client c JOIN c.credits")
    List<Client> findClientsWithCredits();
}