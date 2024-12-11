package ma.hariti.asmaa.wrm.majesticcup.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {
    @Id
    private String id;

    @Field("name")
    private String name;

    @Field("surname")
    private String surname;

    @Field("position")
    private String position;

    @Field("assists")
    private int assists;

    @Field("total_cards")
    private int totalCards;

    @Field("number")
    private int number;

    @Field("goals")
    private int goals;

    @Field("team_id")
    private String teamId;
    @Field("yellowCards")
    private int yellowCards;
    @Field("redCards")
    private int redCards;
    @DBRef(lazy = true)
    @Field("team")
    private Team team;

    public void setTeam(Team team) {
        this.team = team;
        if (team != null) {
            this.teamId = team.getId();
        }
    }
}