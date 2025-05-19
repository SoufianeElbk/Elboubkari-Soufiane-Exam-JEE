package ma.elboubkari.soufiane.repositories;

import ma.elboubkari.soufiane.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByEmail(String email);

    List<Client> findByNomContainsIgnoreCase(String nom);

    @Query("SELECT DISTINCT c FROM Client c JOIN c.credits")
    List<Client> findClientsWithCredits();

    List<Client> findByCreditsIsNotEmpty();
}