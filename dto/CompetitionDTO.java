package ma.hariti.asmaa.wrm.majesticcup.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class CompetitionDTO {
    private String id;
    private String name;
    private int numberOfTeams;

    public CompetitionDTO(String id, String name, int numberOfTeams) {
        this.id = id;
        this.name = name;
        this.numberOfTeams = numberOfTeams;
    }
}
