package ma.hariti.asmaa.wrm.majesticcup.controller;

import ma.hariti.asmaa.wrm.majesticcup.dto.ApiResponseDTO;
import ma.hariti.asmaa.wrm.majesticcup.dto.MatchResultDTO;
import ma.hariti.asmaa.wrm.majesticcup.dto.StatisticsDTO;
import ma.hariti.asmaa.wrm.majesticcup.service.MatchService;
import ma.hariti.asmaa.wrm.majesticcup.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public")
public class PublicController {

    private final MatchService matchService;
    private final StatisticsService statisticsService;

    @Autowired
    public PublicController(MatchService matchService, StatisticsService statisticsService) {
        this.matchService = matchService;
        this.statisticsService = statisticsService;
    }

    // Public - Get all match results
//    @GetMapping("/results")
//    public ResponseEntity<ApiResponseDTO<List<MatchResultDTO>>> getMatchResults() {
//        List<MatchResultDTO> results = matchService.getAllMatchResults();
//        return ResponseEntity.ok(ApiResponseDTO.success(results));
//    }

    // Public - Get top scorers (Ranking of top scorers)
//    @GetMapping("/statistics/top-scorers")
//    public ResponseEntity<ApiResponseDTO<List<StatisticsDTO>>> getTopScorers() {
//        List<StatisticsDTO> topScorers = statisticsService.getTopScorers();
//        return ResponseEntity.ok(ApiResponseDTO.success(topScorers));
//    }

    // Public - Get top assist providers (Ranking of top assists)
//    @GetMapping("/statistics/top-assists")
//    public ResponseEntity<ApiResponseDTO<List<StatisticsDTO>>> getTopAssists() {
//        List<StatisticsDTO> topAssists = statisticsService.getTopAssists();
//        return ResponseEntity.ok(ApiResponseDTO.success(topAssists));
//    }

    // Public - Get top cards (Ranking of most yellow/red cards)
//    @GetMapping("/statistics/cards")
//    public ResponseEntity<ApiResponseDTO<List<StatisticsDTO>>> getTopCards() {
//        List<StatisticsDTO> topCards = statisticsService.getTopCards();
//        return ResponseEntity.ok(ApiResponseDTO.success(topCards));
//    }
}
