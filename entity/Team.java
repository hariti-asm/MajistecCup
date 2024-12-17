package ma.hariti.asmaa.wrm.majesticcup.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "teams")
public class Team {
    @Id
    @JsonProperty("_id")
    private String id;

    @JsonProperty("name")
    @Field("name")
    private String name;

    @JsonProperty("city")
    @Field("city")
    private String city;
    @JsonProperty("players")
    @Field("players")
    private List<Player> players;

}

