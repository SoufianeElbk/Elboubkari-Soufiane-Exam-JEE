package ma.elboubkari.soufiane.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import ma.elboubkari.soufiane.dtos.ClientDTO;
import ma.elboubkari.soufiane.dtos.CreditDTO;
import ma.elboubkari.soufiane.services.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@AllArgsConstructor
@Tag(name = "Client Management API", description = "API endpoints for managing clients")
@CrossOrigin("*")
public class ClientRestController {

    private final ClientService clientService;

    @PostMapping
    @Operation(summary = "Create a new client",
            description = "Creates a new client and returns the created client details")
    public ResponseEntity<ClientDTO> saveClient(@RequestBody ClientDTO clientDTO) {
        return ResponseEntity.ok(clientService.saveClient(clientDTO));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a client by ID")
    @ApiResponse(responseCode = "200", description = "Client found")
    @ApiResponse(responseCode = "404", description = "Client not found")
    public ResponseEntity<ClientDTO> getClient(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    @GetMapping
    @Operation(summary = "Get all clients")
    public ResponseEntity<List<ClientDTO>> getAllClients() {
        return ResponseEntity.ok(clientService.getAllClients());
    }

    @PutMapping
    @Operation(summary = "Update a client")
    public ResponseEntity<ClientDTO> updateClient(@RequestBody ClientDTO clientDTO) {
        return ResponseEntity.ok(clientService.updateClient(clientDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a client")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.ok().build();
    }

//    @GetMapping("/search")
//    @Operation(summary = "Search clients by name")
//    public ResponseEntity<List<ClientDTO>> searchClientsByName(@RequestParam String name) {
//        return ResponseEntity.ok(clientService.searchClientsByName(name));
//    }

//    @GetMapping("/with-credits")
//    @Operation(summary = "Get all clients who have credits")
//    public ResponseEntity<List<ClientDTO>> getClientsWithCredits() {
//        return ResponseEntity.ok(clientService.getClientsWithCredits());
//    }

//    @GetMapping("/{id}/credits")
//    @Operation(summary = "Get all credits for a specific client")
//    public ResponseEntity<List<CreditDTO>> getClientCredits(@PathVariable Long id) {
//        return ResponseEntity.ok(clientService.getClientCredits(id));
//    }

//    @PostMapping("/{id}/credits")
//    @Operation(summary = "Add a credit to a client")
//    public ResponseEntity<ClientDTO> addCreditToClient(
//            @PathVariable Long id,
//            @RequestBody CreditDTO creditDTO) {
//        return ResponseEntity.ok(clientService.addCreditToClient(id, creditDTO));
//    }
}