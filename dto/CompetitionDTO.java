package ma.hariti.asmaa.wrm.majesticcup.dto;


import lombok.Data;

import java.util.List;

@Data
public class CompetitionDTO {
    private String id;
    private String name;
    private int numberOfTeams;
    private List<String> teams;
    private int currentRound;
    private List<String> rounds;


    public CompetitionDTO(String id, String name, int numberOfTeams, List<String> teams, int currentRound, List<String> rounds) {
        this.id = id;
        this.name = name;
        this.numberOfTeams = numberOfTeams;
        this.teams = teams;
        this.currentRound = currentRound;
        this.rounds = rounds;
    }
}
