package ma.hariti.asmaa.wrm.majesticcup.service;

import jakarta.persistence.EntityNotFoundException;
import ma.hariti.asmaa.wrm.majesticcup.dto.CompetitionDTO;
import ma.hariti.asmaa.wrm.majesticcup.entity.Competition;
import ma.hariti.asmaa.wrm.majesticcup.entity.Round;
import ma.hariti.asmaa.wrm.majesticcup.entity.Team;
import ma.hariti.asmaa.wrm.majesticcup.mapper.CompetitionMapper;
import ma.hariti.asmaa.wrm.majesticcup.repository.CompetitionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CompetitionService {

    private final CompetitionRepository competitionRepository;
    private final CompetitionMapper competitionMapper;
    private final RoundService roundService;

    public CompetitionService(CompetitionRepository competitionRepository, CompetitionMapper competitionMapper, RoundService roundService) {
        this.competitionRepository = competitionRepository;
        this.competitionMapper = competitionMapper;
        this.roundService = roundService;
    }

    public CompetitionDTO createCompetition(CompetitionDTO competitionDTO) {
        Competition competition = competitionMapper.toEntity(competitionDTO);
        Competition savedCompetition = competitionRepository.save(competition);
        return competitionMapper.toDTO(savedCompetition);
    }

    public List<CompetitionDTO> getAllCompetitions() {
        List<Competition> competitions = competitionRepository.findAll();
        return competitions.stream()
                .map(competitionMapper::toDTO)
                .toList();
    }

    public CompetitionDTO getCompetitionById(String id) {
        Optional<Competition> competition = competitionRepository.findById(id);
        if (competition.isPresent()) {
            return competitionMapper.toDTO(competition.get());
        } else {
            throw new RuntimeException("Competition not found with ID: " + id);
        }
    }

//    public CompetitionDTO updateCompetition(String id, CompetitionDTO competitionDTO) {
//        Optional<Competition> existingCompetition = competitionRepository.findById(id);
//        if (existingCompetition.isPresent()) {
//            Competition competition = existingCompetition.get();
//            competition.setName(competitionDTO.getName());
//            competition.setNumberOfTeams(competitionDTO.getNumberOfTeams());
//            // Additional fields to be updated can go here
//            Competition updatedCompetition = competitionRepository.save(competition);
//            return competitionMapper.toDTO(updatedCompetition);
//        } else {
//            throw new RuntimeException("Competition not found with ID: " + id);
//        }
//    }

    public void deleteCompetition(String id) {
        Optional<Competition> competition = competitionRepository.findById(id);
        if (competition.isPresent()) {
            competitionRepository.delete(competition.get());
        } else {
            throw new RuntimeException("Competition not found with ID: " + id);
        }
    }
//    @Transactional
//    public CompetitionDTO progressToNextRound(String competitionId) {
//        Competition competition = competitionRepository.findById(competitionId)
//                .orElseThrow(() -> new EntityNotFoundException("Competition not found"));
//
//        Round lastRound = roundService.getRoundByCompetitionAndRoundNumber(
//                competitionId, competition.getCurrentRound()
//        );
//
//        // Determine winners
//        List<Team> winners = roundService.determineWinners(lastRound);
//
//        // Create next round
//        Round nextRound = roundService.createNextRound(competition, winners);
//        competition.getRounds().add(nextRound.getId());
//        competition.setCurrentRound(competition.getCurrentRound() + 1);
//
//        Competition savedCompetition = competitionRepository.save(competition);
//        return competitionMapper.toDTO(savedCompetition);
//    }
}
