package com.example.backendconstructionapplication.controller;

import com.example.backendconstructionapplication.data.supplier.DataSupplier;
import com.example.backendconstructionapplication.dto.WorkerDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/worker")
@RestController
@RequiredArgsConstructor
public class WorkerController {

    @Operation(summary = "Get all workers", description = "Retrieve all active workers")
    @ApiResponse(responseCode = "200", description = "Successful retrieval of all milestones",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "400", description = "Bad request, invalid input",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "403", description = "Forbidden, access denied",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "404", description = "No workers found",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "500", description = "Internal server error, please try again later",
            content = @Content(mediaType = "application/json"))
    @GetMapping("/workers")
    public ResponseEntity<List<WorkerDTO>> getAllWorkers(){
        return new ResponseEntity<>(DataSupplier.getExtensionWorker(), HttpStatus.OK);
    }

    @Operation(summary = "Get workers by id", description = "Retrieve a construction worker by its ID")
    @ApiResponse(responseCode = "200", description = "Successful retrieval of all milestones",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "400", description = "Bad request, invalid input",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "403", description = "Forbidden, access denied",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "404", description = "Worker not found",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "500", description = "Internal server error, please try again later",
            content = @Content(mediaType = "application/json"))
    @GetMapping("/workers/{id}")
    public ResponseEntity<WorkerDTO> getWorkerById(@PathVariable Long id){
        WorkerDTO worker = DataSupplier.getWorkerById(id);
        if (worker == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(worker, HttpStatus.OK);
    }

    @Operation(summary = "Delete worker", description = "Delete a worker by ID")
    @ApiResponse(responseCode = "200", description = "Successful deleting of the worker",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "400", description = "Bad request, invalid input",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "404", description = "Worker not found",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "403", description = "Forbidden, access denied",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "500", description = "Internal server error, please try again later",
            content = @Content(mediaType = "application/json"))
    @DeleteMapping("/workers/{id}")
    public HttpStatus deleteWorker(@PathVariable Long id) {
        DataSupplier.deleteWorkerById(id);
        return HttpStatus.OK;
    }

    @Operation(summary = "Updating worker", description = "Update a worker by ID")
    @ApiResponse(responseCode = "200", description = "Successful editing of the worker",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "400", description = "Bad request, invalid input",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "404", description = "Worker not found",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "403", description = "Forbidden, access denied",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "500", description = "Internal server error, please try again later",
            content = @Content(mediaType = "application/json"))
    @PutMapping("/workers/{id}")
    public ResponseEntity<WorkerDTO> updateWorker(@PathVariable Long id, @RequestBody WorkerDTO dto) {
        DataSupplier.updateWorkerById(id, dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Add new worker", description = "Add a new construction worker")
    @ApiResponse(responseCode = "201", description = "Worker successfully added",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "400", description = "Bad request, invalid input",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "403", description = "Forbidden, access denied",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "500", description = "Internal server error, please try again later",
            content = @Content(mediaType = "application/json"))
    @PostMapping("/workers")
    public ResponseEntity<WorkerDTO> addWorker(@RequestBody WorkerDTO worker) {
        DataSupplier.addWorker(worker);
        return new ResponseEntity<>(worker, HttpStatus.CREATED);
    }
}
