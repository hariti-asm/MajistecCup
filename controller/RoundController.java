package ma.hariti.asmaa.wrm.majesticcup.controller;

import lombok.RequiredArgsConstructor;
import ma.hariti.asmaa.wrm.majesticcup.dto.RoundDTO;
import ma.hariti.asmaa.wrm.majesticcup.entity.Round;
import ma.hariti.asmaa.wrm.majesticcup.service.RoundService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/operator/rounds")
@RequiredArgsConstructor
public class RoundController {

    private final RoundService roundService;

    @PostMapping()
    public ResponseEntity<RoundDTO> createRoundWithMatches(@RequestBody RoundDTO roundDTO) {
        RoundDTO createdRound = roundService.createRoundWithMatches(roundDTO);
        return ResponseEntity.ok(createdRound);
    }

    @GetMapping("/{roundId}")
    public ResponseEntity<Round> getRoundWithMatchesById(@PathVariable String roundId) {
        Round roundDTO = roundService.getRoundWithMatchesById(roundId);
        return ResponseEntity.ok(roundDTO);
    }

    @GetMapping()
    public ResponseEntity<List<Round>> getAllRounds() {
        List<Round> rounds = roundService.getAllRoundsWithMatches();
        return ResponseEntity.ok(rounds);
    }

    @PutMapping("/{roundId}")
    public ResponseEntity<RoundDTO> updateRoundWithMatches(@PathVariable String roundId, @RequestBody RoundDTO roundDTO) {
        RoundDTO updatedRound = roundService.updateRoundWithMatches(roundId, roundDTO);
        return ResponseEntity.ok(updatedRound);
    }

    @DeleteMapping("/{roundId}")
    public ResponseEntity<Void> deleteRoundWithMatches(@PathVariable String roundId) {
        roundService.deleteRoundWithMatches(roundId);
        return ResponseEntity.noContent().build();
    }
}
