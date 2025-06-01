package com.example.backendconstructionapplication.controller;

import com.example.backendconstructionapplication.data.supplier.DataSupplier;
import com.example.backendconstructionapplication.dto.ProjectDTO;
import com.example.backendconstructionapplication.dto.TeamDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/team")
@RestController
@RequiredArgsConstructor
public class TeamController {

    @Operation(summary = "Get all team", description = "Retrieve all active construction team")
    @ApiResponse(responseCode = "200", description = "Successful retrieval of all teams",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "400", description = "Bad request, invalid input",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "403", description = "Forbidden, access denied",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "404", description = "No teams found",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "500", description = "Internal server error, please try again later",
            content = @Content(mediaType = "application/json"))
    @GetMapping("/teams")
    public ResponseEntity<List<TeamDTO>> getAllTeams() {
        return new ResponseEntity<>(DataSupplier.getExtensionTeam(), HttpStatus.OK);
    }

    @Operation(summary = "Get team by ID", description = "Retrieve a construction team by its ID")
    @ApiResponse(responseCode = "200", description = "Successful retrieval of the team",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "400", description = "Bad request, invalid input",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "404", description = "Team not found",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "403", description = "Forbidden, access denied",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "500", description = "Internal server error, please try again later",
            content = @Content(mediaType = "application/json"))
    @GetMapping("/teams/{id}")
    public ResponseEntity<TeamDTO> getTeamById(@PathVariable Long id) {
        TeamDTO team = DataSupplier.getTeamById(id);
        if (team == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(team, HttpStatus.OK);
    }

    @Operation(summary = "Delete team", description = "Delete a team by ID")
    @ApiResponse(responseCode = "200", description = "Successful deleting of the team",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "400", description = "Bad request, invalid input",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "404", description = "Team not found",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "403", description = "Forbidden, access denied",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "500", description = "Internal server error, please try again later",
            content = @Content(mediaType = "application/json"))
    @DeleteMapping("/teams/{id}")
    public HttpStatus deleteTeam(@PathVariable Long id) {
        DataSupplier.deleteTeamById(id);
        return HttpStatus.OK;
    }

    @Operation(summary = "Updating team", description = "Update a team by ID")
    @ApiResponse(responseCode = "200", description = "Successful editing of the team",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "400", description = "Bad request, invalid input",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "404", description = "Team not found",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "403", description = "Forbidden, access denied",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "500", description = "Internal server error, please try again later",
            content = @Content(mediaType = "application/json"))
    @PutMapping("/teams/{id}")
    public ResponseEntity<TeamDTO> updateTeam(@PathVariable Long id, @RequestBody TeamDTO dto) {
        DataSupplier.updateTeamById(id, dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Add new team", description = "Add a new construction team to the system")
    @ApiResponse(responseCode = "201", description = "Team successfully added",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "400", description = "Bad request, invalid input",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "403", description = "Forbidden, access denied",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "500", description = "Internal server error, please try again later",
            content = @Content(mediaType = "application/json"))
    @PostMapping("/teams")
    public ResponseEntity<TeamDTO> addTeam(@RequestBody TeamDTO team) {
        DataSupplier.addTeam(team);
        return new ResponseEntity<>(team, HttpStatus.CREATED);
    }


}
