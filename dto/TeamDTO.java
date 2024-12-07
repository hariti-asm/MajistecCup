package ma.hariti.asmaa.wrm.majesticcup.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamDTO {
    private String id;
    private String name;
    private String city;

    public TeamDTO(String id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }
}
