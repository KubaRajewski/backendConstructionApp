package com.example.backendconstructionapplication.controller;

import com.example.backendconstructionapplication.data.supplier.DataSupplier;
import com.example.backendconstructionapplication.dto.ConstructionDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/construction")
@RestController
@RequiredArgsConstructor
public class ConstructionController {

    @Operation(summary = "Get all constructions", description = "Retrieve all active constructions")
    @ApiResponse(responseCode = "200", description = "Successful retrieval of all constructions",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "400", description = "Bad request, invalid input",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "403", description = "Forbidden, access denied",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "404", description = "No constructions found",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "500", description = "Internal server error, please try again later",
            content = @Content(mediaType = "application/json"))
    @GetMapping("/constructions")
    public ResponseEntity<List<ConstructionDTO>> getAllConstruction() {
        return new ResponseEntity<>(DataSupplier.getExtensionConstruction(), HttpStatus.OK);
    }

    @Operation(summary = "Get construction by id", description = "Retrieve a construction by its ID")
    @ApiResponse(responseCode = "200", description = "Successful retrieval of thr construction",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "400", description = "Bad request, invalid input",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "403", description = "Forbidden, access denied",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "404", description = "Construction not found",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "500", description = "Internal server error, please try again later",
            content = @Content(mediaType = "application/json"))
    @GetMapping("/constructions/{id}")
    public ResponseEntity<ConstructionDTO> getConstructionById(@PathVariable Long id) {
        ConstructionDTO construction = DataSupplier.getConstructionById(id);
        if (construction == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(construction, HttpStatus.OK);
    }

    @Operation(summary = "Delete construction", description = "Delete a construction by ID")
    @ApiResponse(responseCode = "200", description = "Successful deleting of the construction",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "400", description = "Bad request, invalid input",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "404", description = "construction not found",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "403", description = "Forbidden, access denied",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "500", description = "Internal server error, please try again later",
            content = @Content(mediaType = "application/json"))
    @DeleteMapping("/constructions/{id}")
    public HttpStatus deleteConstruction(@PathVariable Long id) {
        DataSupplier.deleteConstructionById(id);
        return HttpStatus.OK;
    }

    @Operation(summary = "Update construction", description = "Update a construction by ID")
    @ApiResponse(responseCode = "200", description = "Successful editing of the construction",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "400", description = "Bad request, invalid input",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "404", description = "Construction not found",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "403", description = "Forbidden, access denied",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "500", description = "Internal server error, please try again later",
            content = @Content(mediaType = "application/json"))
    @PutMapping("/constructions/{id}")
    public ResponseEntity<ConstructionDTO> updateConstruction(@PathVariable Long id, @RequestBody ConstructionDTO dto) {
        DataSupplier.updateConstructionById(id, dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Add new construction", description = "Add a new construction site to the system")
    @ApiResponse(responseCode = "201", description = "Construction successfully added",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "400", description = "Bad request, invalid input",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "403", description = "Forbidden, access denied",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "500", description = "Internal server error, please try again later",
            content = @Content(mediaType = "application/json"))
    @PostMapping("/constructions")
    public ResponseEntity<ConstructionDTO> addConstruction(@RequestBody ConstructionDTO construction) {
        DataSupplier.addConstruction(construction);
        return new ResponseEntity<>(construction, HttpStatus.CREATED);
    }

}
