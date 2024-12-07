package ma.hariti.asmaa.wrm.majesticcup.service;

import ma.hariti.asmaa.wrm.majesticcup.dto.PlayerDTO;
import ma.hariti.asmaa.wrm.majesticcup.entity.Player;
import ma.hariti.asmaa.wrm.majesticcup.mapper.PlayerMapper;
import ma.hariti.asmaa.wrm.majesticcup.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsService {
//    @Autowired
//    private PlayerRepository playerRepository;
//    @Autowired
//    private PlayerMapper playerMapper;
//
//    public List<PlayerDTO> getTopScorers(int limit) {
//        List<Player> topScorers = playerRepository.findTopByGoalsOrderByGoalsDesc(limit);
//        return playerMapper.toDTOList(topScorers);
//    }
//
//    public List<PlayerDTO> getTopAssists(int limit) {
//        List<Player> topAssists = playerRepository.findTopByAssistsOrderByAssistsDesc(limit);
//        return playerMapper.toDTOList(topAssists);
//    }
//
//    public List<PlayerDTO> getTopCardRecipients(int limit) {
//        List<Player> topCards = playerRepository.findTopByTotalCardsOrderByTotalCardsDesc(limit);
//        return playerMapper.toDTOList(topCards);
//    }
}

