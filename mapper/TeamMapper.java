package ma.hariti.asmaa.wrm.majesticcup.mapper;

import ma.hariti.asmaa.wrm.majesticcup.dto.PlayerDTO;
import ma.hariti.asmaa.wrm.majesticcup.dto.TeamDTO;
import ma.hariti.asmaa.wrm.majesticcup.entity.Player;
import ma.hariti.asmaa.wrm.majesticcup.entity.Team;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring", uses = {PlayerMapper.class})
public interface TeamMapper {
    // Convert TeamDTO to Team
    @Mapping(target = "players", qualifiedByName = "mapPlayerDTOsToPlayers")
    Team teamDTOToTeam(TeamDTO teamDTO);

    // Convert Team to TeamDTO
    @Mapping(target = "players", qualifiedByName = "mapPlayersToPlayerDTOs")
    TeamDTO teamToTeamDTO(Team team);

    List<Team> teamDTOsToTeams(List<TeamDTO> teamDTOs);

    List<TeamDTO> teamsToTeamDTOs(List<Team> teams);

    // Custom mapping method to handle players
    @Named("mapPlayerDTOsToPlayers")
    default List<Player> mapPlayerDTOsToPlayers(List<PlayerDTO> playerDTOs) {
        if (playerDTOs == null) {
            return null;
        }

        PlayerMapper playerMapper = new PlayerMapperImpl(); // Or use @Autowired if in a Spring context
        List<Player> players = new ArrayList<>();

        for (PlayerDTO playerDTO : playerDTOs) {
            Player player = playerMapper.playerDTOToPlayer(playerDTO);
            players.add(player);
        }

        return players;
    }

    @Named("mapPlayersToPlayerDTOs")
    default List<PlayerDTO> mapPlayersToPlayerDTOs(List<Player> players) {
        if (players == null) {
            return null;
        }

        PlayerMapper playerMapper = new PlayerMapperImpl(); // Or use @Autowired if in a Spring context
        List<PlayerDTO> playerDTOs = new ArrayList<>();

        for (Player player : players) {
            PlayerDTO playerDTO = playerMapper.playerToPlayerDTO(player);
            playerDTOs.add(playerDTO);
        }

        return playerDTOs;
    }
}