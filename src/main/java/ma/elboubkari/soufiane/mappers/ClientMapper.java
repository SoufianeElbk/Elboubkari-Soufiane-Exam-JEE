package ma.elboubkari.soufiane.mappers;

import ma.elboubkari.soufiane.dtos.ClientDTO;
import ma.elboubkari.soufiane.entities.Client;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ClientMapper {

    public Client fromClientDTO(ClientDTO clientDTO) {
        Client client = new Client();
        client.setId(clientDTO.getId());
        client.setNom(clientDTO.getNom());
        client.setEmail(clientDTO.getEmail());
        // clientDTO.setCredits(new ArrayList<>());
        return client;

    }

    public ClientDTO fromClient(Client client) {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId(client.getId());
        clientDTO.setNom(client.getNom());
        clientDTO.setEmail(client.getEmail());
        // clientDTO.setCredits(new ArrayList<>());
        return clientDTO;
    }
}
