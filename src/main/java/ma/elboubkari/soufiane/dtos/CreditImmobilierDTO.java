package ma.elboubkari.soufiane.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.elboubkari.soufiane.enums.TypeBien;

@Data @NoArgsConstructor @AllArgsConstructor
public class CreditImmobilierDTO extends CreditDTO {
    private TypeBien typeBien;
}