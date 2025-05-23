package com.example.backendconstructionapplication.controller;

import com.example.backendconstructionapplication.data.supplier.DataSupplier;
import com.example.backendconstructionapplication.dto.ContractorDTO;
import com.example.backendconstructionapplication.dto.MaterialDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/material")
@RestController
@RequiredArgsConstructor
public class MaterialController {

    @Operation(summary = "Get all materials", description = "Retrieve all active materials")
    @ApiResponse(responseCode = "200", description = "Successful retrieval of all materials",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "400", description = "Bad request, invalid input",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "403", description = "Forbidden, access denied",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "404", description = "No materials found",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "500", description = "Internal server error, please try again later",
            content = @Content(mediaType = "application/json"))
    @GetMapping("/materials")
    public ResponseEntity<List<MaterialDTO>> getAllMaterials(){
        return new ResponseEntity<>(DataSupplier.getExtensionMaterial(), HttpStatus.OK);
    }

    @Operation(summary = "Get material by id", description = "Retrieve a construction material by its ID")
    @ApiResponse(responseCode = "200", description = "Successful retrieval of the material",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "400", description = "Bad request, invalid input",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "403", description = "Forbidden, access denied",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "404", description = "Material not found",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "500", description = "Internal server error, please try again later",
            content = @Content(mediaType = "application/json"))
    @GetMapping("/materials/{id}")
    public ResponseEntity<MaterialDTO> getMaterialById(@PathVariable Long id){
        MaterialDTO material = DataSupplier.getMaterialById(id);
        if (material == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(material, HttpStatus.OK);
    }

    @Operation(summary = "Delete material", description = "Delete a material by ID")
    @ApiResponse(responseCode = "200", description = "Successful deleting of the material",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "400", description = "Bad request, invalid input",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "404", description = "Material not found",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "403", description = "Forbidden, access denied",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "500", description = "Internal server error, please try again later",
            content = @Content(mediaType = "application/json"))
    @DeleteMapping("/materials/{id}")
    public HttpStatus deleteMaterial(@PathVariable Long id) {
        DataSupplier.deleteMaterialById(id);
        return HttpStatus.OK;
    }

    @Operation(summary = "Updating material", description = "Update a material by ID")
    @ApiResponse(responseCode = "200", description = "Successful editing of the material",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "400", description = "Bad request, invalid input",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "404", description = "Material not found",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "403", description = "Forbidden, access denied",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "500", description = "Internal server error, please try again later",
            content = @Content(mediaType = "application/json"))
    @PutMapping("/materials/{id}")
    public ResponseEntity<MaterialDTO> updateMaterial(@PathVariable Long id, @RequestBody MaterialDTO dto) {
        DataSupplier.updateMaterialById(id, dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Add new material", description = "Add a new building material to the system")
    @ApiResponse(responseCode = "201", description = "Material successfully added",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "400", description = "Bad request, invalid input",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "403", description = "Forbidden, access denied",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "500", description = "Internal server error, please try again later",
            content = @Content(mediaType = "application/json"))
    @PostMapping("/materials")
    public ResponseEntity<MaterialDTO> addMaterial(@RequestBody MaterialDTO material) {
        DataSupplier.addMaterial(material);
        return new ResponseEntity<>(material, HttpStatus.CREATED);
    }

}
