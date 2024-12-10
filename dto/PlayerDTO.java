package ma.hariti.asmaa.wrm.majesticcup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDTO {
    private String id;
    private String name;
    private String surname;
    private String position;
    private int assists;
    private int totalCards;
    private int number;
    private int goals;
    private String teamId;
}