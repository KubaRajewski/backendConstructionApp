package com.example.backendconstructionapplication.controller;


// we can manage each document object over here

import com.example.backendconstructionapplication.data.supplier.DataSupplier;
import com.example.backendconstructionapplication.dto.DocumentDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/document")
@RestController
@RequiredArgsConstructor
public class DocumentController {

    @Operation(summary = "Get all documents", description = "Retrieve all active documents")
    @ApiResponse(responseCode = "200", description = "Successful retrieval of all documents",
    content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "400", description = "Bad request, invalid input",
    content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "403", description = "Forbidden, access denied",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "404", description = "No documents found",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "500", description = "Internal server error, please try again later",
            content = @Content(mediaType = "application/json"))
    @GetMapping("/documents")
    public ResponseEntity<List<DocumentDTO>> getAllDocuments(){
        return new ResponseEntity<>(DataSupplier.getExtensionDocument(), HttpStatus.OK);
    }

    @Operation(summary = "Get documents by id", description = "Retrieve a document by its ID")
    @ApiResponse(responseCode = "200", description = "Successful retrieval of the document",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "400", description = "Bad request, invalid input",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "403", description = "Forbidden, access denied",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "404", description = "Document not found",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "500", description = "Internal server error, please try again later",
            content = @Content(mediaType = "application/json"))
    @GetMapping("/documents/{id}")
    public ResponseEntity<DocumentDTO> getDocumentById(@PathVariable Long id){
        DocumentDTO document = DataSupplier.getDocumentById(id);
        if (document == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(document, HttpStatus.OK);
    }

    @Operation(summary = "Delete document", description = "Delete a document by ID")
    @ApiResponse(responseCode = "200", description = "Successful deleting of the document",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "400", description = "Bad request, invalid input",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "404", description = "Document not found",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "403", description = "Forbidden, access denied",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "500", description = "Internal server error, please try again later",
            content = @Content(mediaType = "application/json"))
    @DeleteMapping("/documents/{id}")
    public HttpStatus deleteDocument(@PathVariable Long id) {
        DataSupplier.deleteDocumentById(id);
        return HttpStatus.OK;
    }

    @Operation(summary = "Updating document", description = "Update a document by ID")
    @ApiResponse(responseCode = "200", description = "Successful editing of the document",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "400", description = "Bad request, invalid input",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "404", description = "Document not found",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "403", description = "Forbidden, access denied",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "500", description = "Internal server error, please try again later",
            content = @Content(mediaType = "application/json"))
    @PutMapping("/documents/{id}")
    public ResponseEntity<DocumentDTO> updateDocument(@PathVariable Long id, @RequestBody DocumentDTO dto) {
        DataSupplier.updateDocumentById(id, dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Add new document", description = "Add a new document to the system")
    @ApiResponse(responseCode = "201", description = "Document successfully added",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "400", description = "Bad request, invalid input",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "403", description = "Forbidden, access denied",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "500", description = "Internal server error, please try again later",
            content = @Content(mediaType = "application/json"))
    @PostMapping("/documents")
    public ResponseEntity<DocumentDTO> addDocument(@RequestBody DocumentDTO document) {
        DataSupplier.addDocument(document);
        return new ResponseEntity<>(document, HttpStatus.CREATED);
    }

}
