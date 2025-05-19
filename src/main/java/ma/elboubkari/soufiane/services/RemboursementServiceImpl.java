package ma.elboubkari.soufiane.services;

import lombok.AllArgsConstructor;
import ma.elboubkari.soufiane.dtos.RemboursementDTO;
import ma.elboubkari.soufiane.entities.Remboursement;
import ma.elboubkari.soufiane.mappers.RemboursementMapper;
import ma.elboubkari.soufiane.repositories.RemboursementRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class RemboursementServiceImpl implements RemboursementService {
    private RemboursementRepository remboursementRepository;
    private RemboursementMapper remboursementMapper;

    @Override
    public RemboursementDTO saveRemboursement(RemboursementDTO remboursementDTO) {
        Remboursement remboursement = remboursementMapper.fromRemboursementDTO(remboursementDTO);
        Remboursement savedRemboursement = remboursementRepository.save(remboursement);
        return remboursementMapper.fromRemboursement(savedRemboursement);
    }

    @Override
    public RemboursementDTO getRemboursementById(Long id) {
        Remboursement remboursement = remboursementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Remboursement not found"));
        return remboursementMapper.fromRemboursement(remboursement);
    }

    @Override
    public List<RemboursementDTO> getAllRemboursements() {
        List<Remboursement> remboursements = remboursementRepository.findAll();
        return remboursements.stream()
                .map(remboursementMapper::fromRemboursement)
                .collect(Collectors.toList());
    }

    @Override
    public RemboursementDTO updateRemboursement(RemboursementDTO remboursementDTO) {
        Remboursement remboursement = remboursementMapper.fromRemboursementDTO(remboursementDTO);
        Remboursement updatedRemboursement = remboursementRepository.save(remboursement);
        return remboursementMapper.fromRemboursement(updatedRemboursement);
    }

    @Override
    public void deleteRemboursement(Long id) {
        remboursementRepository.deleteById(id);
    }
}