package ma.hariti.asmaa.wrm.majesticcup.service;

import lombok.RequiredArgsConstructor;
import ma.hariti.asmaa.wrm.majesticcup.dto.MatchDTO;
import ma.hariti.asmaa.wrm.majesticcup.dto.RoundDTO;
import ma.hariti.asmaa.wrm.majesticcup.entity.Match;
import ma.hariti.asmaa.wrm.majesticcup.entity.Round;
import ma.hariti.asmaa.wrm.majesticcup.mapper.MatchMapper;
import ma.hariti.asmaa.wrm.majesticcup.mapper.RoundMapper;
import ma.hariti.asmaa.wrm.majesticcup.repository.RoundRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoundService {
    private final RoundRepository roundRepository;
    private final MatchService matchService;
    private final RoundMapper roundMapper;
    private final MatchMapper matchMapper;

    @Transactional
    public RoundDTO createRoundWithMatches(RoundDTO roundDTO) {
        if (roundDTO.getCompetitionId() == null) {
            throw new IllegalArgumentException("Competition ID must be provided");
        }

        List<MatchDTO> savedMatchDTOs = roundDTO.getMatches().stream()
                .map(matchDTO -> {
                    matchDTO.setRound(roundDTO.getRoundNumber());
                    return matchService.createMatch(matchDTO);
                })
                .collect(Collectors.toList());

        Round round = new Round();
        round.setRoundNumber(roundDTO.getRoundNumber());
        round.setCompetitionId(roundDTO.getCompetitionId());

        List<Match> savedMatches = savedMatchDTOs.stream()
                .map(matchMapper::toEntity)
                .collect(Collectors.toList());

        round.setMatches(savedMatches);

        Round savedRound = roundRepository.save(round);

        RoundDTO savedRoundDTO = roundMapper.toDTO(savedRound);
        savedRoundDTO.setMatches(savedMatchDTOs);

        return savedRoundDTO;
    }
    @Transactional(readOnly = true)
    public Round getRoundWithMatchesById(String roundId) {


        return roundRepository.findById(roundId)
                .orElseThrow(() -> new EntityNotFoundException("Round not found with ID: " + roundId));
    }

    @Transactional
    public RoundDTO updateRoundWithMatches(String roundId, RoundDTO roundDTO) {
        Round existingRound = roundRepository.findById(roundId)
                .orElseThrow(() -> new EntityNotFoundException("Round not found with ID: " + roundId));

        existingRound.setRoundNumber(roundDTO.getRoundNumber());
        existingRound.setCompetitionId(roundDTO.getCompetitionId());

        List<MatchDTO> updatedMatches = roundDTO.getMatches().stream()
                .map(matchDTO -> {
                    matchDTO.setRound(roundDTO.getRoundNumber());
                    return matchDTO.getId() != null
                            ? matchService.updateMatch(matchDTO.getId(), matchDTO)
                            : matchService.createMatch(matchDTO);
                })
                .collect(Collectors.toList());

        List<Match> savedMatches = updatedMatches.stream()
                .map(matchMapper::toEntity)
                .collect(Collectors.toList());

        existingRound.setMatches(savedMatches);

        Round updatedRound = roundRepository.save(existingRound);

        RoundDTO updatedRoundDTO = roundMapper.toDTO(updatedRound);
        updatedRoundDTO.setMatches(updatedMatches);

        return updatedRoundDTO;
    }

    @Transactional
    public void deleteRoundWithMatches(String roundId) {
        Round round = roundRepository.findById(roundId)
                .orElseThrow(() -> new EntityNotFoundException("Round not found with ID: " + roundId));

        round.getMatches().forEach(match -> {
            matchService.deleteMatch(match.getId());
        });

        roundRepository.delete(round);
    }
    @Transactional()
    public List<Round> getAllRoundsWithMatches() {

        return roundRepository.findAll();
    }

}
