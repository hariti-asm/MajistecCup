package ma.hariti.asmaa.wrm.majesticcup.entity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor

@Document(collection = "competitions")
public class Competition {
    @MongoId
    @JsonProperty("_id")
    private String id;

    @JsonProperty("name")
    @Field("name")
    private String name;

    @JsonProperty("numberOfTeams")
    @Field("numberOfTeams")
    private int numberOfTeams;

    @JsonProperty("teams")
    @Field("teams")
    private List<String> teams;

    @JsonProperty("currentRound")
    @Field("currentRound")
    private int currentRound;

    @JsonProperty("rounds")
    @Field("rounds")
    private List<String> rounds;
}
