package ma.hariti.asmaa.wrm.majesticcup.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import ma.hariti.asmaa.wrm.majesticcup.dto.CompetitionDTO;
import ma.hariti.asmaa.wrm.majesticcup.entity.Competition;
import ma.hariti.asmaa.wrm.majesticcup.mapper.CompetitionMapper;
import ma.hariti.asmaa.wrm.majesticcup.repository.CompetitionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CompetitionService {

    private final CompetitionRepository competitionRepository;
    private final CompetitionMapper competitionMapper;

    public CompetitionDTO createCompetition(CompetitionDTO competitionDTO) {
        Competition competition = competitionMapper.toEntity(competitionDTO);
        Competition savedCompetition = competitionRepository.save(competition);
        return competitionMapper.toDTO(savedCompetition);
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
