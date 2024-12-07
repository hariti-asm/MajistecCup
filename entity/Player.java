package ma.hariti.asmaa.wrm.majesticcup.entity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.management.ConstructorParameters;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "players")
public class Player {
    @MongoId
    @JsonProperty("_id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("surname")
    private String surname;

    @JsonProperty("position")
    private String position;
    @JsonProperty
    private int assists;
    @JsonProperty
    private int totalCards;
    @JsonProperty("number")
    private int number;
@JsonProperty
private int goals;
    @DBRef
    private Team team;
}
