package com.API.EasyMoney.BackEnd.Controllers;

import com.API.EasyMoney.BackEnd.Dtos.WorkingInformationDTO;
import com.API.EasyMoney.BackEnd.Services.WorkingInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/workingInformation")
public class WorkingInformationController {
    // Inject the WorkingInformationService
    @Autowired
    private WorkingInformationService workingInformationService;

    // Get all working information
    @GetMapping
    public ResponseEntity<List<WorkingInformationDTO>> getAllWorkingInformation() {
        try {
            // If not exist working information return not found
            if (workingInformationService.getAllWorkingInformation().isEmpty()) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok(workingInformationService.getAllWorkingInformation());
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Get all working information by id
    @GetMapping("/{id}")
    public ResponseEntity<WorkingInformationDTO> getWorkingInformationById(@PathVariable Long id) {
        try {
            // Get the working information by id
            WorkingInformationDTO workingInformationDTO = workingInformationService.getWorkingInformationById(id);
            // If not exist working information return not found
            if (workingInformationDTO == null) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok(workingInformationDTO);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Create a new working information
    @PostMapping
    public ResponseEntity<WorkingInformationDTO> createWorkingInformation(@RequestBody WorkingInformationDTO dto) {
        try {
            // Create the working information
            WorkingInformationDTO workingInformationDTO = workingInformationService.createWorkingInformation(dto);
            // Return the working information
            return ResponseEntity.ok(workingInformationDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Update a working information
    @PutMapping("/{id}")
    public ResponseEntity<WorkingInformationDTO> updateWorkingInformation(@PathVariable Long id, @RequestBody WorkingInformationDTO dto) {
        try {
            // If not exist working information return not found
            if (workingInformationService.getWorkingInformationById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            // Update the working information
            WorkingInformationDTO workingInformationDTO = workingInformationService.updateWorkingInformation(id, dto);
            // Return the working information
            return ResponseEntity.ok(workingInformationDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Delete a working information
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkingInformation(@PathVariable Long id) {
        try {
            // If not exist working information return not found
            if (workingInformationService.getWorkingInformationById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            // Delete the working information
            workingInformationService.deleteWorkingInformation(id);
            // Return no content
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
