package ma.hariti.asmaa.wrm.majesticcup.mapper;

import ma.hariti.asmaa.wrm.majesticcup.dto.CompetitionDTO;
import ma.hariti.asmaa.wrm.majesticcup.entity.Competition;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CompetitionMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "numberOfTeams", source = "numberOfTeams")
    @Mapping(target = "teams", source = "teams")
    @Mapping(target = "currentRound", source = "currentRound")
    @Mapping(target = "rounds", source = "rounds")
    CompetitionDTO toDTO(Competition competition);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "numberOfTeams", source = "numberOfTeams")
    @Mapping(target = "teams", source = "teams")
    @Mapping(target = "currentRound", source = "currentRound", defaultValue = "1")
    @Mapping(target = "rounds", source = "rounds")
    Competition toEntity(CompetitionDTO competitionDTO);
}