package ma.hariti.asmaa.wrm.majesticcup.controller;

import ma.hariti.asmaa.wrm.majesticcup.dto.ApiResponseDTO;
import ma.hariti.asmaa.wrm.majesticcup.dto.CompetitionDTO;
import ma.hariti.asmaa.wrm.majesticcup.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final CompetitionService competitionService;

    @Autowired
    public AdminController(CompetitionService competitionService) {
        this.competitionService = competitionService;
    }

    @PostMapping(value = "/competitions", produces = "application/json")
    public ResponseEntity<ApiResponseDTO<CompetitionDTO>> createCompetition(@RequestBody CompetitionDTO competitionDTO) {
        CompetitionDTO createdCompetition = competitionService.createCompetition(competitionDTO);
        ApiResponseDTO<CompetitionDTO> response = ApiResponseDTO.success(createdCompetition);
        return ResponseEntity.ok(response);
    }


    @GetMapping(value = "/competitions", produces = "application/json")
    public ResponseEntity<ApiResponseDTO<List<CompetitionDTO>>> getAllCompetitions() {
        List<CompetitionDTO> competitions = competitionService.getAllCompetitions();
        return ResponseEntity.ok(ApiResponseDTO.<List<CompetitionDTO>>success(competitions));
    }

    @DeleteMapping("/competitions/{id}")
    public ResponseEntity<ApiResponseDTO<Void>> deleteCompetition(@PathVariable String id) {
        competitionService.deleteCompetition(id);
        return ResponseEntity.ok(ApiResponseDTO.<Void>success(null));
    }
    @PutMapping(value = "/competitions/{id}", produces = "application/json")
    public ResponseEntity<ApiResponseDTO<CompetitionDTO>> updateCompetition(
            @PathVariable String id,
            @RequestBody CompetitionDTO competitionDTO
    ) {
        CompetitionDTO updatedCompetition = competitionService.updateCompetition(id, competitionDTO);
        return ResponseEntity.ok(ApiResponseDTO.success(updatedCompetition));
    }
}
