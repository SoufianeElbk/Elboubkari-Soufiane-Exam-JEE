package ma.elboubkari.soufiane.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.elboubkari.soufiane.entities.Credit;

@Data @NoArgsConstructor @AllArgsConstructor
public class CreditProfessionnelDTO extends CreditDTO {
    private String motif;
    private String raisonSociale;
}