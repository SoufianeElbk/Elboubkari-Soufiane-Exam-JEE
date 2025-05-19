package ma.elboubkari.soufiane.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import ma.elboubkari.soufiane.dtos.*;
import ma.elboubkari.soufiane.services.CreditService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/credits")
@AllArgsConstructor
@Tag(name = "Credit Management API", description = "API pour la gestion des crédits")
@CrossOrigin("*")
public class CreditRestController {
    private CreditService creditService;

    // APIs génériques
    @GetMapping("/{id}")
    @Operation(summary = "Récupérer un crédit par son ID")
    public ResponseEntity<CreditDTO> getCreditById(@PathVariable Long id) {
        return ResponseEntity.ok(creditService.getCreditById(id));
    }

    @GetMapping
    @Operation(summary = "Récupérer tous les crédits")
    public ResponseEntity<List<CreditDTO>> getAllCredits() {
        return ResponseEntity.ok(creditService.getAllCredits());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un crédit")
    public ResponseEntity<Void> deleteCredit(@PathVariable Long id) {
        creditService.deleteCredit(id);
        return ResponseEntity.ok().build();
    }

    // APIs pour CreditPersonnel
    @PostMapping("/personnel")
    @Operation(summary = "Créer un crédit personnel")
    public ResponseEntity<CreditPersonnelDTO> saveCreditPersonnel(@RequestBody CreditPersonnelDTO creditDTO) {
        return ResponseEntity.ok(creditService.saveCreditPersonnel(creditDTO));
    }

    @PutMapping("/personnel")
    @Operation(summary = "Mettre à jour un crédit personnel")
    public ResponseEntity<CreditPersonnelDTO> updateCreditPersonnel(@RequestBody CreditPersonnelDTO creditDTO) {
        return ResponseEntity.ok(creditService.updateCreditPersonnel(creditDTO));
    }

    @GetMapping("/personnel")
    @Operation(summary = "Récupérer tous les crédits personnels")
    public ResponseEntity<List<CreditPersonnelDTO>> getAllCreditsPersonnels() {
        return ResponseEntity.ok(creditService.getAllCreditsPersonnels());
    }

    @GetMapping("/personnel/search")
    @Operation(summary = "Rechercher des crédits personnels par motif")
    public ResponseEntity<List<CreditPersonnelDTO>> getCreditsPersonnelsByMotif(@RequestParam String motif) {
        return ResponseEntity.ok(creditService.getCreditsPersonnelsByMotif(motif));
    }

    // APIs pour CreditImmobilier
    @PostMapping("/immobilier")
    @Operation(summary = "Créer un crédit immobilier")
    public ResponseEntity<CreditImmobilierDTO> saveCreditImmobilier(@RequestBody CreditImmobilierDTO creditDTO) {
        return ResponseEntity.ok(creditService.saveCreditImmobilier(creditDTO));
    }

    @PutMapping("/immobilier")
    @Operation(summary = "Mettre à jour un crédit immobilier")
    public ResponseEntity<CreditImmobilierDTO> updateCreditImmobilier(@RequestBody CreditImmobilierDTO creditDTO) {
        return ResponseEntity.ok(creditService.updateCreditImmobilier(creditDTO));
    }

    @GetMapping("/immobilier")
    @Operation(summary = "Récupérer tous les crédits immobiliers")
    public ResponseEntity<List<CreditImmobilierDTO>> getAllCreditsImmobiliers() {
        return ResponseEntity.ok(creditService.getAllCreditsImmobiliers());
    }

    @GetMapping("/immobilier/search")
    @Operation(summary = "Rechercher des crédits immobiliers par type de bien")
    public ResponseEntity<List<CreditImmobilierDTO>> getCreditsImmobiliersByTypeBien(@RequestParam String typeBien) {
        return ResponseEntity.ok(creditService.getCreditsImmobiliersByTypeBien(typeBien));
    }

    // APIs pour CreditProfessionnel
    @PostMapping("/professionnel")
    @Operation(summary = "Créer un crédit professionnel")
    public ResponseEntity<CreditProfessionnelDTO> saveCreditProfessionnel(@RequestBody CreditProfessionnelDTO creditDTO) {
        return ResponseEntity.ok(creditService.saveCreditProfessionnel(creditDTO));
    }

    @PutMapping("/professionnel")
    @Operation(summary = "Mettre à jour un crédit professionnel")
    public ResponseEntity<CreditProfessionnelDTO> updateCreditProfessionnel(@RequestBody CreditProfessionnelDTO creditDTO) {
        return ResponseEntity.ok(creditService.updateCreditProfessionnel(creditDTO));
    }

    @GetMapping("/professionnel")
    @Operation(summary = "Récupérer tous les crédits professionnels")
    public ResponseEntity<List<CreditProfessionnelDTO>> getAllCreditsProfessionnels() {
        return ResponseEntity.ok(creditService.getAllCreditsProfessionnels());
    }

    @GetMapping("/professionnel/search")
    @Operation(summary = "Rechercher des crédits professionnels par raison sociale")
    public ResponseEntity<List<CreditProfessionnelDTO>> getCreditsProfessionnelsByRaisonSociale(@RequestParam String raisonSociale) {
        return ResponseEntity.ok(creditService.getCreditsProfessionnelsByRaisonSociale(raisonSociale));
    }
}