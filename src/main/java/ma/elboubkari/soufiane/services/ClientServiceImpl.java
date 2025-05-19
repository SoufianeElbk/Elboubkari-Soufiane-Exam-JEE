package ma.elboubkari.soufiane.services;

import lombok.AllArgsConstructor;
import ma.elboubkari.soufiane.dtos.ClientDTO;
import ma.elboubkari.soufiane.dtos.CreditDTO;
import ma.elboubkari.soufiane.entities.Client;
import ma.elboubkari.soufiane.entities.Credit;
import ma.elboubkari.soufiane.mappers.ClientMapper;
import ma.elboubkari.soufiane.mappers.CreditMapper;
import ma.elboubkari.soufiane.repositories.ClientRepository;
import ma.elboubkari.soufiane.services.ClientService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {
    private ClientRepository clientRepository;
    private ClientMapper clientMapper;
    private CreditMapper creditMapper;

    @Override
    public ClientDTO saveClient(ClientDTO clientDTO) {
        Client client = clientMapper.fromClientDTO(clientDTO);
        Client savedClient = clientRepository.save(client);
        return clientMapper.fromClient(savedClient);
    }

    @Override
    public ClientDTO getClientById(Long id) throws Exception {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new Exception("Client not found with id: " + id));
        return clientMapper.fromClient(client);
    }

    @Override
    public List<ClientDTO> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream()
                .map(clientMapper::fromClient)
                .collect(Collectors.toList());
    }

    @Override
    public ClientDTO updateClient(ClientDTO clientDTO) {
        Client client = clientMapper.fromClientDTO(clientDTO);
        Client updatedClient = clientRepository.save(client);
        return clientMapper.fromClient(updatedClient);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }


}