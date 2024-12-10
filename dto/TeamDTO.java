package ma.hariti.asmaa.wrm.majesticcup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamDTO {
    private String id;
    private String name;
    private String city;
    private List<PlayerDTO> players;

}