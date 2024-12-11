package ma.hariti.asmaa.wrm.majesticcup.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "matches")
public class Match {
    @Id
    private String id;
    private int round;
    private String team1;
    private String team2;
    private MatchResult result;
    private String winner;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MatchResult {
        private int team1Goals;
        private int team2Goals;
        private List<PlayerStatistic> statistics;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PlayerStatistic {
        private String playerId;
        private int goals;
        private int assists;
        private int yellowCards;
        private int redCards;
    }
}