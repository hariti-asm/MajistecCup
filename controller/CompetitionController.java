package ma.hariti.asmaa.wrm.majesticcup.controller;

import ma.hariti.asmaa.wrm.majesticcup.dto.ApiResponseDTO;
import ma.hariti.asmaa.wrm.majesticcup.dto.CompetitionDTO;
import ma.hariti.asmaa.wrm.majesticcup.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/competitions")
public class CompetitionController {
//    @Autowired
//    private CompetitionService competitionService;
//
//    @PostMapping
//    @PreAuthorize("hasRole('ADMIN')")
//    public ResponseEntity<ApiResponseDTO<CompetitionDTO>> createCompetition(
//            @RequestBody CompetitionDTO competitionDTO
//    ) {
//        CompetitionDTO savedCompetition = competitionService.createCompetition(competitionDTO);
//        return ResponseEntity.ok(ApiResponseDTO.success(savedCompetition));
//    }

//    @PostMapping("/{competitionId}/progress")
//    @PreAuthorize("hasRole('ADMIN')")
//    public ResponseEntity<ApiResponseDTO<CompetitionDTO>> progressToNextRound(
//            @PathVariable String competitionId
//    ) {
//        CompetitionDTO updatedCompetition = competitionService.progressToNextRound(competitionId);
//        return ResponseEntity.ok(ApiResponseDTO.success(updatedCompetition));
//    }
}
