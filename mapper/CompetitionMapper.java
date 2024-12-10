package ma.hariti.asmaa.wrm.majesticcup.mapper;

import ma.hariti.asmaa.wrm.majesticcup.dto.CompetitionDTO;
import ma.hariti.asmaa.wrm.majesticcup.entity.Competition;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CompetitionMapper {

    @Mapping(target = "id", source = "id")
    CompetitionDTO toDTO(Competition competition);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "teams", ignore = true)
    @Mapping(target = "currentRound", ignore = true)
    @Mapping(target = "rounds", ignore = true)
    Competition toEntity(CompetitionDTO competitionDTO);
}