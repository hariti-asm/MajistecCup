package ma.hariti.asmaa.wrm.majesticcup.service;

import ma.hariti.asmaa.wrm.majesticcup.dto.MatchDTO;
import ma.hariti.asmaa.wrm.majesticcup.entity.Match;
import ma.hariti.asmaa.wrm.majesticcup.entity.Round;
import ma.hariti.asmaa.wrm.majesticcup.mapper.MatchMapper;
import ma.hariti.asmaa.wrm.majesticcup.repository.MatchRepository;
import ma.hariti.asmaa.wrm.majesticcup.repository.PlayerRepository;
import ma.hariti.asmaa.wrm.majesticcup.repository.RoundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MatchService {
//    @Autowired
//    private MatchRepository matchRepository;
//    @Autowired
//    private MatchMapper matchMapper;
//    @Autowired
//    private RoundRepository roundRepository;
//    @Autowired
//    private PlayerRepository playerRepository;
//
//    @Transactional
//    public MatchDTO recordMatchResult(MatchDTO matchDTO) {
//        // Find the match and round
//        Match match = matchRepository.findById(matchDTO.getId())
//                .orElseThrow(() -> new ResourceNotFoundException("Match not found"));
//
//        Round round = roundRepository.findByMatchesContaining(match)
//                .orElseThrow(() -> new ResourceNotFoundException("Round not found"));
//
//        // Update match result
//        match.setResult(matchMapper.resultDtoToEntity(matchDTO.getResult()));
//
//        // Determine winner
//        match.setWinner(determineWinner(match));
//
//        // Update player statistics
//        updatePlayerStatistics(match);
//
//        // Save updated match
//        Match savedMatch = matchRepository.save(match);
//        return matchMapper.toDTO(savedMatch);
//    }
//
//    private String determineWinner(Match match) {
//        MatchResult result = match.getResult();
//        if (result.getTeam1Goals() > result.getTeam2Goals()) {
//            return match.getTeam1();
//        } else if (result.getTeam1Goals() < result.getTeam2Goals()) {
//            return match.getTeam2();
//        }
//        return null; // Draw
//    }
//
//    private void updatePlayerStatistics(Match match) {
//        MatchResult result = match.getResult();
//        result.getStatistics().forEach(stat -> {
//            Player player = playerRepository.findById(stat.getPlayerId())
//                    .orElseThrow(() -> new ResourceNotFoundException("Player not found"));
//
//            // Update player's individual statistics
//            player.setGoals(player.getGoals() + stat.getGoals());
//            player.setAssists(player.getAssists() + stat.getAssists());
//            player.setYellowCards(player.getYellowCards() + stat.getYellowCards());
//            player.setRedCards(player.getRedCards() + stat.getRedCards());
//
//            playerRepository.save(player);
//        });
//    }
}