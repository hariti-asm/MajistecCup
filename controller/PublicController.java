package ma.hariti.asmaa.wrm.majesticcup.controller;

import ma.hariti.asmaa.wrm.majesticcup.dto.ApiResponseDTO;
import ma.hariti.asmaa.wrm.majesticcup.dto.PlayerDTO;
import ma.hariti.asmaa.wrm.majesticcup.service.StatisticsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public")
public class PublicController {

    private final StatisticsService statisticsService;

    public PublicController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping("/statistics/top-scorers")
    public ResponseEntity<ApiResponseDTO<List<PlayerDTO>>> getTopScorers(@RequestParam(defaultValue = "10") int limit) {
        try {
            List<PlayerDTO> topScorers = statisticsService.getTopScorers(limit);
            return ResponseEntity.ok(ApiResponseDTO.success(topScorers));
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body(ApiResponseDTO.error("Error fetching top scorers: " + e.getMessage(), 500));
        }
    }

    @GetMapping("/statistics/top-assists")
    public ResponseEntity<ApiResponseDTO<List<PlayerDTO>>> getTopAssists(@RequestParam(defaultValue = "10") int limit) {
        try {
            List<PlayerDTO> topAssists = statisticsService.getTopAssists(limit);
            return ResponseEntity.ok(ApiResponseDTO.success(topAssists));
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body(ApiResponseDTO.error("Error fetching top assists: " + e.getMessage(), 500));
        }
    }

    @GetMapping("/statistics/cards")
    public ResponseEntity<ApiResponseDTO<List<PlayerDTO>>> getTopCards(@RequestParam(defaultValue = "10") int limit) {
        try {
            List<PlayerDTO> topCards = statisticsService.getTopCardRecipients(limit);
            return ResponseEntity.ok(ApiResponseDTO.success(topCards));
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body(ApiResponseDTO.error("Error fetching top cards: " + e.getMessage(), 500));
        }
    }
}
