package ma.hariti.asmaa.wrm.majesticcup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatchDTO {
    private String id;
    private int round;
    private String team1;
    private String team2;
    private MatchResultDTO result;
    private String winner;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MatchResultDTO {
        private int team1Goals;
        private int team2Goals;
        private List<PlayerStatisticDTO> statistics;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PlayerStatisticDTO {
        private String playerId;
        private int goals;
        private int assists;
        private int yellowCards;
        private int redCards;
    }
}