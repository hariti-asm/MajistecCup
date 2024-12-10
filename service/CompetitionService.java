package ma.hariti.asmaa.wrm.majesticcup.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import ma.hariti.asmaa.wrm.majesticcup.dto.CompetitionDTO;
import ma.hariti.asmaa.wrm.majesticcup.entity.Competition;
import ma.hariti.asmaa.wrm.majesticcup.mapper.CompetitionMapper;
import ma.hariti.asmaa.wrm.majesticcup.repository.CompetitionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CompetitionService {

    private final CompetitionRepository competitionRepository;
    private final CompetitionMapper competitionMapper;

    public CompetitionDTO createCompetition(CompetitionDTO competitionDTO) {
        // If teams or rounds are not initialized, create empty lists
        if (competitionDTO.getTeams() == null) {
            competitionDTO.setTeams(new ArrayList<>());
        }
        if (competitionDTO.getRounds() == null) {
            competitionDTO.setRounds(new ArrayList<>());
        }

        // Set current round to 1 if not specified
        if (competitionDTO.getCurrentRound() == 0) {
            competitionDTO.setCurrentRound(1);
        }

        // Convert DTO to entity
        Competition competition = competitionMapper.toEntity(competitionDTO);

        // Save the competition
        Competition savedCompetition = competitionRepository.save(competition);

        // Convert back to DTO and return
        return competitionMapper.toDTO(savedCompetition);
    }

    // Method to add a team to the competition
    public CompetitionDTO addTeamToCompetition(String competitionId, String teamId) {
        Competition competition = competitionRepository.findById(competitionId)
                .orElseThrow(() -> new EntityNotFoundException("Competition not found with ID: " + competitionId));

        // Ensure teams list is initialized
        if (competition.getTeams() == null) {
            competition.setTeams(new ArrayList<>());
        }

        // Add team if not already present
        if (!competition.getTeams().contains(teamId)) {
            competition.getTeams().add(teamId);
        }

        // Save and return
        Competition updatedCompetition = competitionRepository.save(competition);
        return competitionMapper.toDTO(updatedCompetition);
    }

    // Method to add a round to the competition
    public CompetitionDTO addRoundToCompetition(String competitionId, String roundId) {
        Competition competition = competitionRepository.findById(competitionId)
                .orElseThrow(() -> new EntityNotFoundException("Competition not found with ID: " + competitionId));

        // Ensure rounds list is initialized
        if (competition.getRounds() == null) {
            competition.setRounds(new ArrayList<>());
        }

        // Add round if not already present
        if (!competition.getRounds().contains(roundId)) {
            competition.getRounds().add(roundId);
        }

        // Save and return
        Competition updatedCompetition = competitionRepository.save(competition);
        return competitionMapper.toDTO(updatedCompetition);
    }

    // Update current round
    public CompetitionDTO updateCurrentRound(String competitionId, int roundNumber) {
        Competition competition = competitionRepository.findById(competitionId)
                .orElseThrow(() -> new EntityNotFoundException("Competition not found with ID: " + competitionId));

        competition.setCurrentRound(roundNumber);

        Competition updatedCompetition = competitionRepository.save(competition);
        return competitionMapper.toDTO(updatedCompetition);
    }


    @Transactional(readOnly = true)
    public List<CompetitionDTO> getAllCompetitions() {
        List<Competition> competitions = competitionRepository.findAll();
        return competitions.stream()
                .map(competitionMapper::toDTO)
                .toList();
    }

    @Transactional(readOnly = true)
    public CompetitionDTO getCompetitionById(String id) {
        Competition competition = competitionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Competition not found with ID: " + id));
        return competitionMapper.toDTO(competition);
    }

    public CompetitionDTO updateCompetition(String id, CompetitionDTO competitionDTO) {
        Competition competition = competitionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Competition not found with ID: " + id));
        competition.setName(competitionDTO.getName());
        competition.setNumberOfTeams(competitionDTO.getNumberOfTeams());
        Competition updatedCompetition = competitionRepository.save(competition);
        return competitionMapper.toDTO(updatedCompetition);
    }

    public void deleteCompetition(String id) {
        Competition competition = competitionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Competition not found with ID: " + id));
        competitionRepository.delete(competition);
    }
}
