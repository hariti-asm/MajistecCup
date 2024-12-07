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

    @PostMapping("/competitions")
    public ResponseEntity<ApiResponseDTO<CompetitionDTO>> createCompetition(@RequestBody CompetitionDTO competitionDTO) {
        CompetitionDTO savedCompetition = competitionService.createCompetition(competitionDTO);
        return ResponseEntity.ok(ApiResponseDTO.success(savedCompetition));
    }

    @GetMapping("/competitions")
    public ResponseEntity<ApiResponseDTO<List<CompetitionDTO>>> getAllCompetitions() {
        List<CompetitionDTO> competitions = competitionService.getAllCompetitions();
        return ResponseEntity.ok(ApiResponseDTO.success(competitions));
    }

    @GetMapping("/competitions/{id}")
    public ResponseEntity<ApiResponseDTO<CompetitionDTO>> getCompetitionById(@PathVariable String id) {
        CompetitionDTO competitionDTO = competitionService.getCompetitionById(id);
        return ResponseEntity.ok(ApiResponseDTO.success(competitionDTO));
    }

//    @PutMapping("/competitions/{id}")
//    public ResponseEntity<ApiResponseDTO<CompetitionDTO>> updateCompetition(@PathVariable String id, @RequestBody CompetitionDTO competitionDTO) {
//        CompetitionDTO updatedCompetition = competitionService.updateCompetition(id, competitionDTO);
//        return ResponseEntity.ok(ApiResponseDTO.success(updatedCompetition));
//    }

    @DeleteMapping("/competitions/{id}")
    public ResponseEntity<ApiResponseDTO<Void>> deleteCompetition(@PathVariable String id) {
        competitionService.deleteCompetition(id);
        return ResponseEntity.ok(ApiResponseDTO.success(null));
    }
}
