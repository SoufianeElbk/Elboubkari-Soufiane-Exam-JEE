package ma.elboubkari.soufiane.services;

import ma.elboubkari.soufiane.dtos.RemboursementDTO;
import ma.elboubkari.soufiane.enums.TypeRemboursement;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface RemboursementService {
    // CRUD opérations
    RemboursementDTO saveRemboursement(RemboursementDTO remboursementDTO);
    RemboursementDTO getRemboursementById(Long id);
    List<RemboursementDTO> getAllRemboursements();
    RemboursementDTO updateRemboursement(RemboursementDTO remboursementDTO);
    void deleteRemboursement(Long id);

    // Opérations supplémentaires
    List<RemboursementDTO> getRemboursementsByCreditId(Long creditId);
    List<RemboursementDTO> getRemboursementsByType(TypeRemboursement type);
    List<RemboursementDTO> getRemboursementsAfterDate(Date date);
    Double getTotalRemboursementsByCreditId(Long creditId);

    // Statistiques
    Map<Long, Double> getTotalRemboursementsByCredit();
    Map<String, Double> getTotalRemboursementsByTypeCredit();
}