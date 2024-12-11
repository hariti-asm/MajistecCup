package ma.hariti.asmaa.wrm.majesticcup.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import ma.hariti.asmaa.wrm.majesticcup.dto.RoundDTO;
import ma.hariti.asmaa.wrm.majesticcup.entity.Round;
import ma.hariti.asmaa.wrm.majesticcup.mapper.RoundMapper;
import ma.hariti.asmaa.wrm.majesticcup.repository.RoundRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class RoundService {
    private final RoundRepository roundRepository;
    private final RoundMapper roundMapper;

    public RoundDTO createRound(RoundDTO roundDTO) {
        if (roundDTO.getCompetitionId() == null) {
            throw new IllegalArgumentException("Competition ID must be provided");
        }
        Round round = roundMapper.toEntity(roundDTO);
        Round savedRound = roundRepository.save(round);
        return roundMapper.toDTO(savedRound);
    }

    @Transactional(readOnly = true)
    public RoundDTO getRoundById(String roundId) {
        Round round = roundRepository.findById(roundId)
                .orElseThrow(() -> new EntityNotFoundException("Round not found with ID: " + roundId));
        return roundMapper.toDTO(round);
    }

    @Transactional(readOnly = true)
    public List<RoundDTO> getAllRounds() {
        List<Round> rounds = roundRepository.findAll();
        return rounds.stream()
                .map(roundMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<RoundDTO> getRoundsByCompetitionId(String competitionId) {
        List<Round> rounds = roundRepository.findByCompetitionId(competitionId);
        return rounds.stream()
                .map(roundMapper::toDTO)
                .collect(Collectors.toList());
    }

    public RoundDTO updateRound(String roundId, RoundDTO roundDTO) {
        Round existingRound = roundRepository.findById(roundId)
                .orElseThrow(() -> new EntityNotFoundException("Round not found with ID: " + roundId));
        existingRound.setRoundNumber(roundDTO.getRoundNumber());
        existingRound.setCompetitionId(roundDTO.getCompetitionId());
        existingRound.setMatchIds(roundDTO.getMatchIds());
        Round updatedRound = roundRepository.save(existingRound);
        return roundMapper.toDTO(updatedRound);
    }

    public void deleteRound(String roundId) {
        Round round = roundRepository.findById(roundId)
                .orElseThrow(() -> new EntityNotFoundException("Round not found with ID: " + roundId));
        roundRepository.delete(round);
    }
}