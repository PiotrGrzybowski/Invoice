package ai.invoice.core;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Response {
    public static ResponseEntity<String> successfulCreation() {
        return new ResponseEntity<>("Successful creation of a resource.", HttpStatus.CREATED);
    }

    public static ResponseEntity<String> failedCreation() {
        return new ResponseEntity<>("Error during creating resource.", HttpStatus.BAD_REQUEST);
    }

    public static ResponseEntity<String> successfulUpdate() {
        return ResponseEntity.ok("Data updated successfully");
    }

    public static ResponseEntity<String> failedUpdate() {
        return new ResponseEntity<>("Error during updating data.", HttpStatus.NOT_FOUND);
    }

    public static ResponseEntity<String> successfulDelete() {
        return new ResponseEntity<>("Data deleted successfully.", HttpStatus.ACCEPTED);
    }

    public static ResponseEntity<String> failedDelete() {
        return new ResponseEntity<>("Resource not found.", HttpStatus.NOT_FOUND);
    }
}