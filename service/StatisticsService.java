package ma.hariti.asmaa.wrm.majesticcup.service;

import lombok.RequiredArgsConstructor;
import ma.hariti.asmaa.wrm.majesticcup.dto.PlayerDTO;
import ma.hariti.asmaa.wrm.majesticcup.entity.Player;
import ma.hariti.asmaa.wrm.majesticcup.mapper.PlayerMapper;
import ma.hariti.asmaa.wrm.majesticcup.repository.PlayerRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatisticsService {

    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    public List<PlayerDTO> getTopScorers(int limit) {
        List<Player> topScorers = playerRepository.findTopByGoalsOrderByGoalsDesc(Pageable.ofSize(limit));
        return mapPlayersToDTOs(topScorers);
    }
    public List<PlayerDTO> getTopAssists(int limit) {
        List<Player> topAssists = playerRepository.findTopByAssistsOrderByAssistsDesc(Pageable.ofSize(limit));
        return mapPlayersToDTOs(topAssists);
    }

    public List<PlayerDTO> getTopCardRecipients(int limit) {
        List<Player> topCards = playerRepository.findTopByTotalCardsOrderByTotalCardsDesc(Pageable.ofSize(limit));
        return mapPlayersToDTOs(topCards);
    }

    private List<PlayerDTO> mapPlayersToDTOs(List<Player> players) {
        return players != null ? playerMapper.toDTOList(players) : List.of();
    }
}
