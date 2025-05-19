package ma.elboubkari.soufiane.mappers;

import ma.elboubkari.soufiane.dtos.RemboursementDTO;
import ma.elboubkari.soufiane.entities.Remboursement;
import org.springframework.stereotype.Component;

@Component
public class RemboursementMapper {

    public RemboursementDTO fromRemboursement(Remboursement remboursement) {
        RemboursementDTO dto = new RemboursementDTO();
        dto.setId(remboursement.getId());
        dto.setDate(remboursement.getDate());
        dto.setMontant(remboursement.getMontant());
        dto.setType(remboursement.getType());
        return dto;
    }

    public Remboursement fromRemboursementDTO(RemboursementDTO remboursementDTO) {
        Remboursement remboursement = new Remboursement();
        remboursement.setId(remboursementDTO.getId());
        remboursement.setDate(remboursementDTO.getDate());
        remboursement.setMontant(remboursementDTO.getMontant());
        remboursement.setType(remboursementDTO.getType());
        return remboursement;
    }
}