package ma.elboubkari.soufiane.services;

import ma.elboubkari.soufiane.dtos.ClientDTO;
import ma.elboubkari.soufiane.dtos.CreditDTO;

import java.util.List;

public interface ClientService {
    // CRUD opérations
    ClientDTO saveClient(ClientDTO clientDTO);
    ClientDTO getClientById(Long id) throws Exception;
    List<ClientDTO> getAllClients();
    ClientDTO updateClient(ClientDTO clientDTO);
    void deleteClient(Long id);

    // Opérations supplémentaires
//    ClientDTO getClientByEmail(String email) throws Exception;
//    List<ClientDTO> searchClientsByName(String name);
//    List<ClientDTO> getClientsWithCredits();
//    List<CreditDTO> getClientCredits(Long clientId);
//    ClientDTO addCreditToClient(Long clientId, CreditDTO creditDTO);
}