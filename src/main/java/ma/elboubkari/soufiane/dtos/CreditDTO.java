package ma.elboubkari.soufiane.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.elboubkari.soufiane.enums.StatutCredit;

import java.util.Date;
import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor
public class CreditDTO {
    private Long id;
    private Date dateDemande;
    private StatutCredit statut;
    private Date dateAcceptation;
    private Double montant;
    private Integer dureeRemboursement;
    private Double tauxInteret;
//    private ClientDTO clientDTO;
//    private String typeCredit;
//    private List<RemboursementDTO> remboursementsDTOS;
}