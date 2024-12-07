package ma.hariti.asmaa.wrm.majesticcup.mapper;

import ma.hariti.asmaa.wrm.majesticcup.dto.CompetitionDTO;
import ma.hariti.asmaa.wrm.majesticcup.entity.Competition;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface CompetitionMapper {
    CompetitionDTO toDTO(Competition competition);
    Competition toEntity(CompetitionDTO competitionDTO);
}