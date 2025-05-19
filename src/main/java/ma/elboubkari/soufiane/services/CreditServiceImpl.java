package ma.elboubkari.soufiane.services;

import lombok.AllArgsConstructor;
import ma.elboubkari.soufiane.dtos.*;
import ma.elboubkari.soufiane.entities.*;
import ma.elboubkari.soufiane.enums.TypeBien;
import ma.elboubkari.soufiane.mappers.CreditMapper;
import ma.elboubkari.soufiane.repositories.*;
import ma.elboubkari.soufiane.services.CreditService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class CreditServiceImpl implements CreditService {
    private CreditRepository creditRepository;
    private CreditPersonnelRepository creditPersonnelRepository;
    private CreditImmobilierRepository creditImmobilierRepository;
    private CreditProfessionnelRepository creditProfessionnelRepository;
    private CreditMapper creditMapper;

    @Override
    public CreditDTO getCreditById(Long id) {
        Credit credit = creditRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Credit not found with id: " + id));

        if (credit instanceof CreditPersonnel) {
            return creditMapper.fromCreditPersonnel((CreditPersonnel) credit);
        } else if (credit instanceof CreditImmobilier) {
            return creditMapper.fromCreditImmobilier((CreditImmobilier) credit);
        } else {
            return creditMapper.fromCreditProfessionnel((CreditProfessionnel) credit);
        }
    }

    @Override
    public List<CreditDTO> getAllCredits() {
        return creditRepository.findAll().stream()
                .map(credit -> {
                    if (credit instanceof CreditPersonnel) {
                        return creditMapper.fromCreditPersonnel((CreditPersonnel) credit);
                    } else if (credit instanceof CreditImmobilier) {
                        return creditMapper.fromCreditImmobilier((CreditImmobilier) credit);
                    } else {
                        return creditMapper.fromCreditProfessionnel((CreditProfessionnel) credit);
                    }
                })
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCredit(Long id) {
        creditRepository.deleteById(id);
    }

    @Override
    public CreditPersonnelDTO saveCreditPersonnel(CreditPersonnelDTO creditDTO) {
        CreditPersonnel credit = creditMapper.fromCreditPersonnelDTO(creditDTO);
        CreditPersonnel savedCredit = creditPersonnelRepository.save(credit);
        return creditMapper.fromCreditPersonnel(savedCredit);
    }

    @Override
    public CreditPersonnelDTO updateCreditPersonnel(CreditPersonnelDTO creditDTO) {
        CreditPersonnel credit = creditMapper.fromCreditPersonnelDTO(creditDTO);
        CreditPersonnel updatedCredit = creditPersonnelRepository.save(credit);
        return creditMapper.fromCreditPersonnel(updatedCredit);
    }


    @Override
    public List<CreditPersonnelDTO> getCreditsPersonnelsByMotif(String motif) {
        List<CreditPersonnel> credits = creditPersonnelRepository.findByMotifContainsIgnoreCase(motif);
        return credits.stream()
                .map(creditMapper::fromCreditPersonnel)
                .collect(Collectors.toList());
    }

    @Override
    public CreditImmobilierDTO saveCreditImmobilier(CreditImmobilierDTO creditDTO) {
        CreditImmobilier credit = creditMapper.fromCreditImmobilierDTO(creditDTO);
        CreditImmobilier savedCredit = creditImmobilierRepository.save(credit);
        return creditMapper.fromCreditImmobilier(savedCredit);
    }

    @Override
    public CreditImmobilierDTO updateCreditImmobilier(CreditImmobilierDTO creditDTO) {
        CreditImmobilier credit = creditMapper.fromCreditImmobilierDTO(creditDTO);
        CreditImmobilier updatedCredit = creditImmobilierRepository.save(credit);
        return creditMapper.fromCreditImmobilier(updatedCredit);
    }


    @Override
    public CreditProfessionnelDTO saveCreditProfessionnel(CreditProfessionnelDTO creditDTO) {
        CreditProfessionnel credit = creditMapper.fromCreditProfessionnelDTO(creditDTO);
        CreditProfessionnel savedCredit = creditProfessionnelRepository.save(credit);
        return creditMapper.fromCreditProfessionnel(savedCredit);
    }

    @Override
    public CreditProfessionnelDTO updateCreditProfessionnel(CreditProfessionnelDTO creditDTO) {
        CreditProfessionnel credit = creditMapper.fromCreditProfessionnelDTO(creditDTO);
        CreditProfessionnel updatedCredit = creditProfessionnelRepository.save(credit);
        return creditMapper.fromCreditProfessionnel(updatedCredit);
    }

    @Override
    public List<CreditProfessionnelDTO> getCreditsProfessionnelsByRaisonSociale(String raisonSociale) {
        List<CreditProfessionnel> credits = creditProfessionnelRepository.findByRaisonSocialeContainsIgnoreCase(raisonSociale);
        return credits.stream()
                .map(creditMapper::fromCreditProfessionnel)
                .collect(Collectors.toList());
    }

    @Override
    public List<CreditPersonnelDTO> getAllCreditsPersonnels() {
        List<CreditPersonnel> credits = creditRepository.findByType(CreditPersonnel.class);
        return credits.stream()
                .map(creditMapper::fromCreditPersonnel)
                .collect(Collectors.toList());
    }

    @Override
    public List<CreditImmobilierDTO> getAllCreditsImmobiliers() {
        List<CreditImmobilier> credits = creditRepository.findByType(CreditImmobilier.class);
        return credits.stream()
                .map(creditMapper::fromCreditImmobilier)
                .collect(Collectors.toList());
    }

    @Override
    public List<CreditImmobilierDTO> getCreditsImmobiliersByTypeBien(String typeBien) {
        List<CreditImmobilier> credits = creditImmobilierRepository.findByTypeBienEquals(TypeBien.valueOf(typeBien));
        return credits.stream()
                .map(creditMapper::fromCreditImmobilier)
                .collect(Collectors.toList());
    }
    @Override
    public List<CreditProfessionnelDTO> getAllCreditsProfessionnels() {
        List<CreditProfessionnel> credits = creditRepository.findByType(CreditProfessionnel.class);
        return credits.stream()
                .map(creditMapper::fromCreditProfessionnel)
                .collect(Collectors.toList());
    }
}