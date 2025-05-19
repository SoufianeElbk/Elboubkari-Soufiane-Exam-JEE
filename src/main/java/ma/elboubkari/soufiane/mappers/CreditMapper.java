package ma.elboubkari.soufiane.mappers;

import ma.elboubkari.soufiane.dtos.*;
import ma.elboubkari.soufiane.entities.*;
import org.springframework.stereotype.Component;

@Component
public class CreditMapper {

    public CreditPersonnelDTO fromCreditPersonnel(CreditPersonnel credit) {
        CreditPersonnelDTO dto = new CreditPersonnelDTO();
        dto.setId(credit.getId());
        dto.setDateDemande(credit.getDateDemande());
        dto.setStatut(credit.getStatut());
        dto.setDateAcceptation(credit.getDateAcceptation());
        dto.setMontant(credit.getMontant());
        dto.setDureeRemboursement(credit.getDureeRemboursement());
        dto.setTauxInteret(credit.getTauxInteret());
        dto.setMotif(credit.getMotif());
        return dto;
    }

    public CreditPersonnel fromCreditPersonnelDTO(CreditPersonnelDTO creditPersonnelDTO) {
        CreditPersonnel creditPersonnel = new CreditPersonnel();
        creditPersonnel.setId(creditPersonnelDTO.getId());
        creditPersonnel.setDateDemande(creditPersonnelDTO.getDateDemande());
        creditPersonnel.setStatut(creditPersonnelDTO.getStatut());
        creditPersonnel.setDateAcceptation(creditPersonnelDTO.getDateAcceptation());
        creditPersonnel.setMontant(creditPersonnelDTO.getMontant());
        creditPersonnel.setDureeRemboursement(creditPersonnelDTO.getDureeRemboursement());
        creditPersonnel.setTauxInteret(creditPersonnelDTO.getTauxInteret());
        creditPersonnel.setMotif(creditPersonnelDTO.getMotif());
        return creditPersonnel;
    }

    public CreditImmobilierDTO fromCreditImmobilier(CreditImmobilier credit) {
        CreditImmobilierDTO dto = new CreditImmobilierDTO();
        dto.setId(credit.getId());
        dto.setDateDemande(credit.getDateDemande());
        dto.setStatut(credit.getStatut());
        dto.setDateAcceptation(credit.getDateAcceptation());
        dto.setMontant(credit.getMontant());
        dto.setDureeRemboursement(credit.getDureeRemboursement());
        dto.setTauxInteret(credit.getTauxInteret());
        dto.setTypeBien(credit.getTypeBien());
        return dto;
    }

    public CreditImmobilier fromCreditImmobilierDTO(CreditImmobilierDTO creditImmobilierDTO) {
        CreditImmobilier credit = new CreditImmobilier();
        credit.setId(creditImmobilierDTO.getId());
        credit.setDateDemande(creditImmobilierDTO.getDateDemande());
        credit.setStatut(creditImmobilierDTO.getStatut());
        credit.setDateAcceptation(creditImmobilierDTO.getDateAcceptation());
        credit.setMontant(creditImmobilierDTO.getMontant());
        credit.setDureeRemboursement(creditImmobilierDTO.getDureeRemboursement());
        credit.setTauxInteret(creditImmobilierDTO.getTauxInteret());
        credit.setTypeBien(creditImmobilierDTO.getTypeBien());
        return credit;
    }

    public CreditProfessionnelDTO fromCreditProfessionnel(CreditProfessionnel credit) {
        CreditProfessionnelDTO dto = new CreditProfessionnelDTO();
        dto.setId(credit.getId());
        dto.setDateDemande(credit.getDateDemande());
        dto.setStatut(credit.getStatut());
        dto.setDateAcceptation(credit.getDateAcceptation());
        dto.setMontant(credit.getMontant());
        dto.setDureeRemboursement(credit.getDureeRemboursement());
        dto.setTauxInteret(credit.getTauxInteret());
        dto.setMotif(credit.getMotif());
        dto.setRaisonSociale(credit.getRaisonSociale());
        return dto;
    }

    public CreditProfessionnel fromCreditProfessionnelDTO(CreditProfessionnelDTO creditProfessionnelDTO) {
        CreditProfessionnel credit = new CreditProfessionnel();
        credit.setId(creditProfessionnelDTO.getId());
        credit.setDateDemande(creditProfessionnelDTO.getDateDemande());
        credit.setStatut(creditProfessionnelDTO.getStatut());
        credit.setDateAcceptation(creditProfessionnelDTO.getDateAcceptation());
        credit.setMontant(creditProfessionnelDTO.getMontant());
        credit.setDureeRemboursement(creditProfessionnelDTO.getDureeRemboursement());
        credit.setTauxInteret(creditProfessionnelDTO.getTauxInteret());
        credit.setMotif(creditProfessionnelDTO.getMotif());
        credit.setRaisonSociale(creditProfessionnelDTO.getRaisonSociale());
        return credit;
    }

}