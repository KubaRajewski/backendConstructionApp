package com.example.backendconstructionapplication.controller;

import com.example.backendconstructionapplication.data.supplier.DataSupplier;
import com.example.backendconstructionapplication.dto.ContractorDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/contractor")
@RestController
@RequiredArgsConstructor
public class ContractorController {

    @Operation(summary = "Get all contractors", description = "Retrieve a contractor by its ID")
    @ApiResponse(responseCode = "200", description = "Successful retrieval of the contractor",
    content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "400", description = "Bad request, invalid input",
    content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "403", description = "Forbidden, access denied",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "404", description = "Contractor not found",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "500", description = "Internal server error, please try again later",
            content = @Content(mediaType = "application/json"))
    @GetMapping("/contractors")
    public ResponseEntity<List<ContractorDTO>> getAllContractors(){
        return new ResponseEntity<>(DataSupplier.getExtensionContractor(), HttpStatus.OK);
    }

    @Operation(summary = "Get contractor by id", description = "Retrieve construction by id")
    @ApiResponse(responseCode = "200", description = "Successful retrieval of contractor",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "400", description = "Bad request, invalid input",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "403", description = "Forbidden, access denied",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "404", description = "No construction found",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "500", description = "Internal server error, please try again later",
            content = @Content(mediaType = "application/json"))
    @GetMapping("/contractors/{id}")
    public ResponseEntity<ContractorDTO> getContractorById(@PathVariable Long id){
        ContractorDTO contractor = DataSupplier.getContractorById(id);
        if (contractor == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(contractor, HttpStatus.OK);
    }

    @Operation(summary = "Delete contractor", description = "Delete a contractor by ID")
    @ApiResponse(responseCode = "200", description = "Successful deleting of the contractor",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "400", description = "Bad request, invalid input",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "404", description = "Contractor not found",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "403", description = "Forbidden, access denied",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "500", description = "Internal server error, please try again later",
            content = @Content(mediaType = "application/json"))
    @DeleteMapping("/contractors/{id}")
    public HttpStatus deleteContractor(@PathVariable Long id) {
        DataSupplier.deleteContractorById(id);
        return HttpStatus.OK;
    }

    @Operation(summary = "Updating contractor", description = "Update a contractor by ID")
    @ApiResponse(responseCode = "200", description = "Successful deleting of the contractor",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "400", description = "Bad request, invalid input",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "404", description = "Contractor not found",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "403", description = "Forbidden, access denied",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "500", description = "Internal server error, please try again later",
            content = @Content(mediaType = "application/json"))
    @PutMapping("/contractors/{id}")
    public ResponseEntity<ContractorDTO> updateConstruction(@PathVariable Long id, @RequestBody ContractorDTO dto) {
        DataSupplier.updateContractorById(id, dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Add new contractor", description = "Add a new contractor assigned to a construction")
    @ApiResponse(responseCode = "201", description = "Contractor successfully added",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "400", description = "Bad request, invalid input",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "403", description = "Forbidden, access denied",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "500", description = "Internal server error, please try again later",
            content = @Content(mediaType = "application/json"))
    @PostMapping("/contractors")
    public ResponseEntity<ContractorDTO> addContractor(@RequestBody ContractorDTO contractor) {
        DataSupplier.addContractor(contractor);
        return new ResponseEntity<>(contractor, HttpStatus.CREATED);
    }

}
