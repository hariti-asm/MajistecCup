package ma.hariti.asmaa.wrm.majesticcup.mapper;

import ma.hariti.asmaa.wrm.majesticcup.dto.RoundDTO;
import ma.hariti.asmaa.wrm.majesticcup.entity.Round;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring")
public interface RoundMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "competitionId", source = "competitionId")
    @Mapping(target = "roundNumber", source = "roundNumber")
    @Mapping(target = "matches", source = "matches")
    RoundDTO toDTO(Round round);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "competitionId", source = "competitionId")
    @Mapping(target = "roundNumber", source = "roundNumber")
    @Mapping(target = "matches", source = "matches")
    Round toEntity(RoundDTO roundDTO);
}