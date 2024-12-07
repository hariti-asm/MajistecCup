package ma.hariti.asmaa.wrm.majesticcup.controller;

import ma.hariti.asmaa.wrm.majesticcup.dto.ApiResponseDTO;
import ma.hariti.asmaa.wrm.majesticcup.dto.TeamDTO;
import ma.hariti.asmaa.wrm.majesticcup.service.TeamService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/teams")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping
    public ApiResponseDTO<TeamDTO> addTeam(@RequestBody TeamDTO teamDTO) {
        TeamDTO savedTeamDTO = teamService.addTeam(teamDTO);
        return ApiResponseDTO.success(savedTeamDTO);
    }

    @GetMapping("/{id}")
    public ApiResponseDTO<TeamDTO> getTeamById(@PathVariable String id) {
        TeamDTO teamDTO = teamService.getTeamById(id);
        return teamDTO != null ? ApiResponseDTO.success(teamDTO) : ApiResponseDTO.error("Team not found", 404);
    }
}
