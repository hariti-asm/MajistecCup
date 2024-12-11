package ma.hariti.asmaa.wrm.majesticcup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoundDTO {
    private String id;
    private String competitionId;
    private int roundNumber;
    private List<MatchDTO> matches;
}