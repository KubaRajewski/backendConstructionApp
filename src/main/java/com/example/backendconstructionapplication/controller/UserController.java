package com.example.backendconstructionapplication.controller;

import com.example.backendconstructionapplication.data.supplier.DataSupplier;
import com.example.backendconstructionapplication.dto.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/user")
@RestController
@RequiredArgsConstructor
public class UserController {

    @Operation(summary = "Get all users", description = "Retrieve all active users")
    @ApiResponse(responseCode = "200", description = "Successful retrieval of all users",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "400", description = "Bad request, invalid input",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "403", description = "Forbidden, access denied",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "404", description = "No user found",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "500", description = "Internal server error, please try again later",
            content = @Content(mediaType = "application/json"))
    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        return new ResponseEntity<>(DataSupplier.getUsers(), HttpStatus.OK);
    }

    @Operation(summary = "Get user by id", description = "Retrieve a construction user by its ID")
    @ApiResponse(responseCode = "200", description = "Successful retrieval of all users",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "400", description = "Bad request, invalid input",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "403", description = "Forbidden, access denied",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "404", description = "User not found",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "500", description = "Internal server error, please try again later",
            content = @Content(mediaType = "application/json"))
    @GetMapping("/users/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id){
        UserDTO user = DataSupplier.getUserById(id);
        if (user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Operation(summary = "Delete user", description = "Delete a user by ID")
    @ApiResponse(responseCode = "200", description = "Successful deleting of the user",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "400", description = "Bad request, invalid input",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "404", description = "User not found",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "403", description = "Forbidden, access denied",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "500", description = "Internal server error, please try again later",
            content = @Content(mediaType = "application/json"))
    @DeleteMapping("/users/{id}")
    public HttpStatus deleteUser(@PathVariable Long id) {
        DataSupplier.deleteUserById(id);
        return HttpStatus.OK;
    }

    @Operation(summary = "Updating user", description = "Update a user by ID")
    @ApiResponse(responseCode = "200", description = "Successful editing of the user",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "400", description = "Bad request, invalid input",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "404", description = "User not found",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "403", description = "Forbidden, access denied",
            content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "500", description = "Internal server error, please try again later",
            content = @Content(mediaType = "application/json"))
    @PutMapping("/users/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO dto) {
        UserDTO updated = DataSupplier.updateUserById(id, dto);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

}
