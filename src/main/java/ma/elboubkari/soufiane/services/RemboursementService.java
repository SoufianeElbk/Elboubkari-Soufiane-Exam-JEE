package ma.elboubkari.soufiane.services;

import ma.elboubkari.soufiane.dtos.RemboursementDTO;
import ma.elboubkari.soufiane.enums.TypeRemboursement;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface RemboursementService {
    RemboursementDTO saveRemboursement(RemboursementDTO remboursementDTO);
    RemboursementDTO getRemboursementById(Long id);
    List<RemboursementDTO> getAllRemboursements();
    RemboursementDTO updateRemboursement(RemboursementDTO remboursementDTO);
    void deleteRemboursement(Long id);

}