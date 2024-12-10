package ma.hariti.asmaa.wrm.majesticcup.controller;


import ma.hariti.asmaa.wrm.majesticcup.dto.ApiResponseDTO;
import ma.hariti.asmaa.wrm.majesticcup.dto.PlayerDTO;
import ma.hariti.asmaa.wrm.majesticcup.dto.TeamDTO;
import ma.hariti.asmaa.wrm.majesticcup.service.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/teams")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping
    public ApiResponseDTO<TeamDTO> addTeam(@RequestBody TeamDTO teamDTO) {
        TeamDTO savedTeamDTO = teamService.addTeamWithPlayers(teamDTO);
        return ApiResponseDTO.success(savedTeamDTO);
    }


    @PutMapping("/{id}")
    public ApiResponseDTO<TeamDTO> updateTeam(@PathVariable String id, @RequestBody TeamDTO teamDTO) {
        TeamDTO updatedTeamDTO = teamService.updateTeamWithPlayers(id, teamDTO);
        return updatedTeamDTO != null ? ApiResponseDTO.success(updatedTeamDTO) : ApiResponseDTO.error("Team not found", 404);
    }

    @DeleteMapping("/{id}")
    public ApiResponseDTO<Void> deleteTeam(@PathVariable String id) {
        boolean isDeleted = teamService.deleteTeam(id);
        return isDeleted ? ApiResponseDTO.success(null) : ApiResponseDTO.error("Team not found", 404);
    }

    @GetMapping
    public ApiResponseDTO<List<TeamDTO>> getAllTeams() {
        List<TeamDTO> teams = teamService.getAllTeams();
        return ApiResponseDTO.success(teams);
    }

    @GetMapping("/{id}")
    public ApiResponseDTO<TeamDTO> getTeamById(@PathVariable String id) {
        TeamDTO teamDTO = teamService.getTeamByIdWithPlayers(id);
        return teamDTO != null ? ApiResponseDTO.success(teamDTO) : ApiResponseDTO.error("Team not found", 404);
    }

    @GetMapping("/{teamId}/players")
    public ResponseEntity<List<PlayerDTO>> getTeamPlayers(@PathVariable String teamId) {
        List<PlayerDTO> players = teamService.getTeamPlayers(teamId);
        return ResponseEntity.ok(players);
    }
}

