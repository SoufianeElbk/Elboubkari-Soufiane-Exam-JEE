package ma.elboubkari.soufiane.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.elboubkari.soufiane.enums.TypeRemboursement;

import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor
public class RemboursementDTO {
    private Long id;
    private Date date;
    private Double montant;
    private TypeRemboursement type;
//    private CreditDTO creditDTO;
}