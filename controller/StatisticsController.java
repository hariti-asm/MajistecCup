package ma.hariti.asmaa.wrm.majesticcup.controller;

import ma.hariti.asmaa.wrm.majesticcup.dto.ApiResponseDTO;
import ma.hariti.asmaa.wrm.majesticcup.dto.PlayerDTO;
import ma.hariti.asmaa.wrm.majesticcup.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/public/statistics")
public class StatisticsController {
//    @Autowired
//    private StatisticsService statisticsService;
//
//    @GetMapping("/top-scorers")
//    public ResponseEntity<ApiResponseDTO<List<PlayerDTO>>> getTopScorers(
//            @RequestParam(defaultValue = "10") int limit
//    ) {
//        List<PlayerDTO> topScorers = statisticsService.getTopScorers(limit);
//        return ResponseEntity.ok(ApiResponseDTO.success(topScorers));
//    }
//
//    @GetMapping("/top-assists")
//    public ResponseEntity<ApiResponseDTO<List<PlayerDTO>>> getTopAssists(
//            @RequestParam(defaultValue = "10") int limit
//    ) {
//        List<PlayerDTO> topAssists = statisticsService.getTopAssists(limit);
//        return ResponseEntity.ok(ApiResponseDTO.success(topAssists));
//    }
//
//    @GetMapping("/cards")
//    public ResponseEntity<ApiResponseDTO<List<PlayerDTO>>> getTopCardRecipients(
//            @RequestParam(defaultValue = "10") int limit
//    ) {
//        List<PlayerDTO> topCards = statisticsService.getTopCardRecipients(limit);
//        return ResponseEntity.ok(ApiResponseDTO.success(topCards));
//    }
}