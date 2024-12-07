package ma.hariti.asmaa.wrm.majesticcup.service;

import ma.hariti.asmaa.wrm.majesticcup.entity.Player;
import ma.hariti.asmaa.wrm.majesticcup.repository.PlayerRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getTopGoalScorers(int limit) {
        return playerRepository.findTopByGoalsOrderByGoalsDesc(PageRequest.of(0, limit));
    }

    public List<Player> getTopAssistProviders(int limit) {
        return playerRepository.findTopByAssistsOrderByAssistsDesc(PageRequest.of(0, limit));
    }

    public List<Player> getTopCardReceivers(int limit) {
        return playerRepository.findTopByTotalCardsOrderByTotalCardsDesc(PageRequest.of(0, limit));
    }
}
