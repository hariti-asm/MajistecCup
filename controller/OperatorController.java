package ma.hariti.asmaa.wrm.majesticcup.controller;


import lombok.RequiredArgsConstructor;
import ma.hariti.asmaa.wrm.majesticcup.dto.ApiResponseDTO;
import ma.hariti.asmaa.wrm.majesticcup.dto.MatchDTO;
import ma.hariti.asmaa.wrm.majesticcup.service.MatchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/operator/matches")
@RequiredArgsConstructor
public class OperatorController {

    private final MatchService matchService;

    @PostMapping
    public ResponseEntity<ApiResponseDTO<MatchDTO>> createMatch(@RequestBody MatchDTO matchDTO) {
        MatchDTO createdMatch = matchService.createMatch(matchDTO);
        return ResponseEntity.ok(ApiResponseDTO.success(createdMatch));
    }

    @PutMapping("/{matchId}/result")
    public ResponseEntity<ApiResponseDTO<MatchDTO>> recordMatchResult(
            @PathVariable String matchId,
            @RequestBody MatchDTO matchDTO) {
        MatchDTO updatedMatch = matchService.recordMatchResult(matchId, matchDTO);
        return ResponseEntity.ok(ApiResponseDTO.success(updatedMatch));
    }

    @GetMapping("/{matchId}")
    public ResponseEntity<ApiResponseDTO<MatchDTO>> getMatchById(@PathVariable String matchId) {
        MatchDTO matchDTO = matchService.getMatchById(matchId);
        return ResponseEntity.ok(ApiResponseDTO.success(matchDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMatch(@PathVariable String id) {
        matchService.deleteMatch(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<MatchDTO> updateMatch(@PathVariable String id, @RequestBody MatchDTO updatedMatchDTO) {
        MatchDTO updatedMatch = matchService.updateMatch(id, updatedMatchDTO);
        return ResponseEntity.ok(updatedMatch);
    }
}

