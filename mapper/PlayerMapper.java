package ma.hariti.asmaa.wrm.majesticcup.mapper;

import ma.hariti.asmaa.wrm.majesticcup.dto.PlayerDTO;
import ma.hariti.asmaa.wrm.majesticcup.entity.Player;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PlayerMapper {

    @Mapping(target = "team", ignore = true)
    Player playerDTOToPlayer(PlayerDTO playerDTO);

    @Mapping(target = "teamId", source = "team.id")
    PlayerDTO playerToPlayerDTO(Player player);
}
