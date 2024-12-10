package ma.hariti.asmaa.wrm.majesticcup.service;

import ma.hariti.asmaa.wrm.majesticcup.dto.PlayerDTO;
import ma.hariti.asmaa.wrm.majesticcup.dto.TeamDTO;
import ma.hariti.asmaa.wrm.majesticcup.entity.Player;
import ma.hariti.asmaa.wrm.majesticcup.entity.Team;
import ma.hariti.asmaa.wrm.majesticcup.mapper.PlayerMapper;
import ma.hariti.asmaa.wrm.majesticcup.mapper.TeamMapper;
import ma.hariti.asmaa.wrm.majesticcup.repository.PlayerRepository;
import ma.hariti.asmaa.wrm.majesticcup.repository.TeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeamService {
    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;
    private final TeamMapper teamMapper;
    private final PlayerMapper playerMapper;

    public TeamService(TeamRepository teamRepository, PlayerRepository playerRepository, TeamMapper teamMapper, PlayerMapper playerMapper) {
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
        this.teamMapper = teamMapper;
        this.playerMapper = playerMapper;
    }

    @Transactional
    public TeamDTO addTeamWithPlayers(TeamDTO teamDTO) {
        if (teamDTO == null) {
            throw new IllegalArgumentException("TeamDTO cannot be null");
        }

        Team team = new Team();
        team.setName(teamDTO.getName());
        team.setCity(teamDTO.getCity());

        Team savedTeam = teamRepository.save(team);

        if (teamDTO.getPlayers() != null && !teamDTO.getPlayers().isEmpty()) {
            List<Player> players = teamDTO.getPlayers().stream()
                    .map(playerDTO -> {
                        Player player = playerMapper.playerDTOToPlayer(playerDTO);
                        player.setTeamId(savedTeam.getId());
                        player.setTeam(null);
                        return player;
                    })
                    .collect(Collectors.toList());

            List<Player> savedPlayers = playerRepository.saveAll(players);

            savedTeam.setPlayers(savedPlayers);
            teamRepository.save(savedTeam);
        }

        return teamMapper.teamToTeamDTO(savedTeam);
    }

    @Transactional
    public TeamDTO updateTeamWithPlayers(String id, TeamDTO teamDTO) {
        Optional<Team> existingTeamOptional = teamRepository.findById(id);
        if (existingTeamOptional.isEmpty()) {
            return null;
        }

        Team existingTeam = existingTeamOptional.get();
        existingTeam.setName(teamDTO.getName());
        existingTeam.setCity(teamDTO.getCity());

        Team updatedTeam = teamRepository.save(existingTeam);

        if (teamDTO.getPlayers() != null && !teamDTO.getPlayers().isEmpty()) {
            playerRepository.deleteByTeamId(id);

            List<Player> newPlayers = teamDTO.getPlayers().stream()
                    .map(playerDTO -> {
                        Player player = playerMapper.playerDTOToPlayer(playerDTO);
                        player.setTeamId(updatedTeam.getId());
                        return player;
                    })
                    .collect(Collectors.toList());

            List<Player> savedPlayers = playerRepository.saveAll(newPlayers);

            updatedTeam.setPlayers(savedPlayers);
            teamRepository.save(updatedTeam);
        }

        return teamMapper.teamToTeamDTO(updatedTeam);
    }

    public TeamDTO getTeamByIdWithPlayers(String id) {
        Team team = teamRepository.findById(id).orElse(null);
        if (team == null) {
            return null;
        }

        TeamDTO teamDTO = teamMapper.teamToTeamDTO(team);

        List<PlayerDTO> players = playerRepository.findByTeamId(id)
                .stream()
                .map(playerMapper::playerToPlayerDTO)
                .collect(Collectors.toList());

        teamDTO.setPlayers(players);

        return teamDTO;
    }

    public List<TeamDTO> getAllTeams() {
        List<Team> teams = teamRepository.findAll();
        return teamMapper.teamsToTeamDTOs(teams);
    }

    public boolean deleteTeam(String id) {
        Optional<Team> team = teamRepository.findById(id);
        if (team.isPresent()) {
            teamRepository.delete(team.get());
            return true;
        }
        return false;
    }

    public List<PlayerDTO> getTeamPlayers(String teamId) {
        List<Player> players = playerRepository.findByTeamId(teamId);
        return players.stream()
                .map(playerMapper::playerToPlayerDTO)
                .collect(Collectors.toList());
    }
}
