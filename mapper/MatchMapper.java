package ma.hariti.asmaa.wrm.majesticcup.mapper;


import ma.hariti.asmaa.wrm.majesticcup.dto.MatchDTO;
import ma.hariti.asmaa.wrm.majesticcup.entity.Match;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MatchMapper {

    MatchMapper INSTANCE = Mappers.getMapper(MatchMapper.class);

    MatchDTO matchToMatchDTO(Match match);
    Match matchDTOToMatch(MatchDTO matchDTO);
}
