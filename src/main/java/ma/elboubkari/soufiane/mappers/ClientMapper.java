package ma.elboubkari.soufiane.mappers;

import ma.elboubkari.soufiane.dtos.ClientDTO;
import ma.elboubkari.soufiane.entities.Client;

import java.util.ArrayList;

public class ClientMapper {

    public static Client fromClientDTO(ClientDTO clientDTO) {
        Client client = new Client();
        client.setId(clientDTO.getId());
        client.setNom(clientDTO.getNom());
        client.setEmail(clientDTO.getEmail());
        // clientDTO.setCredits(new ArrayList<>());
        return client;

    }

    public static ClientDTO fromClient(Client client) {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId(client.getId());
        clientDTO.setNom(client.getNom());
        clientDTO.setEmail(client.getEmail());
        // clientDTO.setCredits(new ArrayList<>());
        return clientDTO;
    }
}
