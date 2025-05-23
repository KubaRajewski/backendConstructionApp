package com.example.backendconstructionapplication.controller;

import com.example.backendconstructionapplication.data.supplier.DataSupplier;
import com.example.backendconstructionapplication.dto.ElementDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/element")
@RestController
@RequiredArgsConstructor
public class ElementController {

    @Operation(summary = "Get all elements", description = "Retrieve all active elements")
    @ApiResponse(responseCode = "200", description = "Successful retrieval of all documents",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "400", description = "Bad request, invalid input",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "403", description = "Forbidden, access denied",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "404", description = "No elements found",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "500", description = "Internal server error, please try again later",
            content = @Content(mediaType = "application/json"))
    @GetMapping("/elements")
    public ResponseEntity<List<ElementDTO>> getAllElements(){
        return new ResponseEntity<>(DataSupplier.getExtensionElement(), HttpStatus.OK);
    }

    @Operation(summary = "Get element by id", description = "Retrieve a construction element by its ID")
    @ApiResponse(responseCode = "200", description = "Successful retrieval of element",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "400", description = "Bad request, invalid input",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "403", description = "Forbidden, access denied",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "404", description = "Element not found",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "500", description = "Internal server error, please try again later",
            content = @Content(mediaType = "application/json"))
    @GetMapping("/elements/{id}")
    public ResponseEntity<ElementDTO> getElementById(@PathVariable Long id){
        ElementDTO element = DataSupplier.getElementById(id);
        if (element == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(element, HttpStatus.OK);
    }

    @Operation(summary = "Delete element", description = "Delete an element by ID")
    @ApiResponse(responseCode = "200", description = "Successful deleting of the element",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "400", description = "Bad request, invalid input",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "404", description = "Element not found",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "403", description = "Forbidden, access denied",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "500", description = "Internal server error, please try again later",
            content = @Content(mediaType = "application/json"))
    @DeleteMapping("/elements/{id}")
    public HttpStatus deleteElement(@PathVariable Long id) {
        DataSupplier.deleteElementById(id);
        return HttpStatus.OK;
    }

    @Operation(summary = "Updating element", description = "Update an element by ID")
    @ApiResponse(responseCode = "200", description = "Successful editing of the element",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "400", description = "Bad request, invalid input",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "404", description = "Element not found",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "403", description = "Forbidden, access denied",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "500", description = "Internal server error, please try again later",
            content = @Content(mediaType = "application/json"))
    @PutMapping("/elements/{id}")
    public ResponseEntity<ElementDTO> updateElement(@PathVariable Long id, @RequestBody ElementDTO dto) {
        DataSupplier.updateElementById(id, dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Add new element", description = "Add a new cost estimate element")
    @ApiResponse(responseCode = "201", description = "Element successfully added",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "400", description = "Bad request, invalid input",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "403", description = "Forbidden, access denied",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "500", description = "Internal server error, please try again later",
            content = @Content(mediaType = "application/json"))
    @PostMapping("/elements")
    public ResponseEntity<ElementDTO> addElement(@RequestBody ElementDTO element) {
        DataSupplier.addElement(element);
        return new ResponseEntity<>(element, HttpStatus.CREATED);
    }

}
