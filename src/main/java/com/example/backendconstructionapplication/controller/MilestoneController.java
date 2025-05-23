package com.example.backendconstructionapplication.controller;

import com.example.backendconstructionapplication.data.supplier.DataSupplier;
import com.example.backendconstructionapplication.dto.MilestoneDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/milestone")
@RestController
@RequiredArgsConstructor
public class MilestoneController {

    @Operation(summary = "Get all milestones", description = "Retrieve all active milestones")
    @ApiResponse(responseCode = "200", description = "Successful retrieval of all milestones",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "400", description = "Bad request, invalid input",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "403", description = "Forbidden, access denied",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "404", description = "No milestones found",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "500", description = "Internal server error, please try again later",
            content = @Content(mediaType = "application/json"))
    @GetMapping("/milestones")
    public ResponseEntity<List<MilestoneDTO>> getAllMilestones(){
        return new ResponseEntity<>(DataSupplier.getExtensionMilestone(), HttpStatus.OK);
    }

    @Operation(summary = "Get all milestone by id", description = "Retrieve a construction milestone by its ID")
    @ApiResponse(responseCode = "200", description = "Successful retrieval of the milestone",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "400", description = "Bad request, invalid input",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "403", description = "Forbidden, access denied",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "404", description = "Milestone not found",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "500", description = "Internal server error, please try again later",
            content = @Content(mediaType = "application/json"))
    @GetMapping("/milestones/{id}")
    public ResponseEntity<MilestoneDTO> getMileStoneById(@PathVariable Long id){
        MilestoneDTO milestone = DataSupplier.getMilestoneById(id);
        if (milestone == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(milestone, HttpStatus.OK);
    }

    @Operation(summary = "Delete milestone", description = "Delete a milestone by ID")
    @ApiResponse(responseCode = "200", description = "Successful deleting of the milestone",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "400", description = "Bad request, invalid input",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "404", description = "Milestone not found",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "403", description = "Forbidden, access denied",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "500", description = "Internal server error, please try again later",
            content = @Content(mediaType = "application/json"))
    @DeleteMapping("/milestones/{id}")
    public HttpStatus deleteMilestone(@PathVariable Long id) {
        DataSupplier.deleteMilestoneById(id);
        return HttpStatus.OK;
    }

    @Operation(summary = "Updating milestone", description = "Update a milestone by ID")
    @ApiResponse(responseCode = "200", description = "Successful editing of the milestone",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "400", description = "Bad request, invalid input",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "404", description = "Milestone not found",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "403", description = "Forbidden, access denied",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "500", description = "Internal server error, please try again later",
            content = @Content(mediaType = "application/json"))
    @PutMapping("/milestones/{id}")
    public ResponseEntity<MilestoneDTO> updateMilestone(@PathVariable Long id, @RequestBody MilestoneDTO dto) {
        DataSupplier.updateMilestoneById(id, dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Add new milestone", description = "Add a new milestone to a construction project")
    @ApiResponse(responseCode = "201", description = "Milestone successfully added",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "400", description = "Bad request, invalid input",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "403", description = "Forbidden, access denied",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "500", description = "Internal server error, please try again later",
            content = @Content(mediaType = "application/json"))
    @PostMapping("/milestones")
    public ResponseEntity<MilestoneDTO> addMilestone(@RequestBody MilestoneDTO milestone) {
        DataSupplier.addMilestone(milestone);
        return new ResponseEntity<>(milestone, HttpStatus.CREATED);
    }

}
