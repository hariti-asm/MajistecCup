package ma.hariti.asmaa.wrm.majesticcup.mapper;


import ma.hariti.asmaa.wrm.majesticcup.dto.TeamDTO;
import ma.hariti.asmaa.wrm.majesticcup.entity.Team;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TeamMapper {

    TeamDTO teamToTeamDTO(Team team);
    Team teamDTOToTeam(TeamDTO teamDTO);
}
