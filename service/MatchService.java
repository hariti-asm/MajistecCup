package ma.hariti.asmaa.wrm.majesticcup.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import ma.hariti.asmaa.wrm.majesticcup.dto.MatchDTO;
import ma.hariti.asmaa.wrm.majesticcup.entity.Match;
import ma.hariti.asmaa.wrm.majesticcup.mapper.MatchMapper;
import ma.hariti.asmaa.wrm.majesticcup.repository.MatchRepository;
import ma.hariti.asmaa.wrm.majesticcup.repository.PlayerRepository;
import ma.hariti.asmaa.wrm.majesticcup.repository.RoundRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MatchService {
    private final MatchRepository matchRepository;
    private final MatchMapper matchMapper;
    private final RoundRepository roundRepository;
    private final PlayerRepository playerRepository;

    @Transactional
    public MatchDTO createMatch(MatchDTO matchDTO) {
        Match match = matchMapper.toEntity(matchDTO);
        Match savedMatch = matchRepository.save(match);
        return matchMapper.toDTO(savedMatch);
    }

    @Transactional
    public MatchDTO recordMatchResult(String matchId, MatchDTO matchDTO) {
        Match match = matchRepository.findById(matchId)
                .orElseThrow(() -> new EntityNotFoundException("Match not found with ID: " + matchId));


        match.setResult(matchMapper.resultDtoToEntity(matchDTO.getResult()));

        match.setWinner(determineWinner(match));

        updatePlayerStatistics(match);

        Match savedMatch = matchRepository.save(match);
        return matchMapper.toDTO(savedMatch);
    }

    @Transactional(readOnly = true)
    public MatchDTO getMatchById(String matchId) {
        Match match = matchRepository.findById(matchId)
                .orElseThrow(() -> new EntityNotFoundException("Match not found with ID: " + matchId));
        return matchMapper.toDTO(match);
    }

    private String determineWinner(Match match) {
        if (match.getResult() == null) {
            return null;
        }

        int team1Goals = match.getResult().getTeam1Goals();
        int team2Goals = match.getResult().getTeam2Goals();

        if (team1Goals > team2Goals) {
            return match.getTeam1();
        } else if (team1Goals < team2Goals) {
            return match.getTeam2();
        }
        return null;
    }

    private void updatePlayerStatistics(Match match) {
        if (match.getResult() == null || match.getResult().getStatistics() == null) {
            return;
        }

        match.getResult().getStatistics().forEach(stat -> {
            playerRepository.findById(stat.getPlayerId())
                    .ifPresent(player -> {
                        player.setGoals(player.getGoals() + stat.getGoals());
                        player.setAssists(player.getAssists() + stat.getAssists());
                        player.setYellowCards(player.getYellowCards() + stat.getYellowCards());
                        player.setRedCards(player.getRedCards() + stat.getRedCards());

                        playerRepository.save(player);
                    });
        });
    }

    @Transactional
    public void deleteMatch(String matchId) {
        if (!matchRepository.existsById(matchId)) {
            throw new EntityNotFoundException("Match not found with ID: " + matchId);
        }
        matchRepository.deleteById(matchId);
    }

    @Transactional
    public MatchDTO updateMatch(String matchId, MatchDTO updatedMatchDTO) {
        Match existingMatch = matchRepository.findById(matchId)
                .orElseThrow(() -> new EntityNotFoundException("Match not found with ID: " + matchId));

        existingMatch.setRound(updatedMatchDTO.getRound());
        existingMatch.setTeam1(updatedMatchDTO.getTeam1());
        existingMatch.setTeam2(updatedMatchDTO.getTeam2());
        existingMatch.setResult(matchMapper.resultDtoToEntity(updatedMatchDTO.getResult()));
        existingMatch.setWinner(determineWinner(existingMatch));

        Match updatedMatch = matchRepository.save(existingMatch);
        return matchMapper.toDTO(updatedMatch);
    }

}