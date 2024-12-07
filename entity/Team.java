package ma.hariti.asmaa.wrm.majesticcup.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Set;
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
    @DBRef
    private Set<Player> players;
}

