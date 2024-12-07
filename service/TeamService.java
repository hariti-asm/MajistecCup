package ma.hariti.asmaa.wrm.majesticcup.service;

import ma.hariti.asmaa.wrm.majesticcup.dto.TeamDTO;
import ma.hariti.asmaa.wrm.majesticcup.entity.Team;
import ma.hariti.asmaa.wrm.majesticcup.mapper.TeamMapper;
import ma.hariti.asmaa.wrm.majesticcup.repository.TeamRepository;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    public TeamService(TeamRepository teamRepository, TeamMapper teamMapper) {
        this.teamRepository = teamRepository;
        this.teamMapper = teamMapper;
    }

    public TeamDTO addTeam(TeamDTO teamDTO) {
        Team team = teamMapper.teamDTOToTeam(teamDTO);
        Team savedTeam = teamRepository.save(team);
        return teamMapper.teamToTeamDTO(savedTeam);
    }

    public TeamDTO getTeamById(String id) {
        Team team = teamRepository.findById(id).orElse(null);
        return team != null ? teamMapper.teamToTeamDTO(team) : null;
    }
}
