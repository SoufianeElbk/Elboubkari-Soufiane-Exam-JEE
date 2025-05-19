package ma.elboubkari.soufiane.services;

import ma.elboubkari.soufiane.dtos.CreditDTO;
import ma.elboubkari.soufiane.dtos.CreditImmobilierDTO;
import ma.elboubkari.soufiane.dtos.CreditPersonnelDTO;
import ma.elboubkari.soufiane.dtos.CreditProfessionnelDTO;
import ma.elboubkari.soufiane.enums.StatutCredit;

import java.util.Date;
import java.util.List;

public interface CreditService {
    // CRUD opérations génériques
    CreditDTO getCreditById(Long id);
    List<CreditDTO> getAllCredits();
    void deleteCredit(Long id);

    // Opérations pour CreditPersonnel
    CreditPersonnelDTO saveCreditPersonnel(CreditPersonnelDTO creditDTO);
    CreditPersonnelDTO updateCreditPersonnel(CreditPersonnelDTO creditDTO);
    List<CreditPersonnelDTO> getAllCreditsPersonnels();
    List<CreditPersonnelDTO> getCreditsPersonnelsByMotif(String motif);

    // Opérations pour CreditImmobilier
    CreditImmobilierDTO saveCreditImmobilier(CreditImmobilierDTO creditDTO);
    CreditImmobilierDTO updateCreditImmobilier(CreditImmobilierDTO creditDTO);
    List<CreditImmobilierDTO> getAllCreditsImmobiliers();
    List<CreditImmobilierDTO> getCreditsImmobiliersByTypeBien(String typeBien);

    // Opérations pour CreditProfessionnel
    CreditProfessionnelDTO saveCreditProfessionnel(CreditProfessionnelDTO creditDTO);
    CreditProfessionnelDTO updateCreditProfessionnel(CreditProfessionnelDTO creditDTO);
    List<CreditProfessionnelDTO> getAllCreditsProfessionnels();
    List<CreditProfessionnelDTO> getCreditsProfessionnelsByRaisonSociale(String raisonSociale);

}