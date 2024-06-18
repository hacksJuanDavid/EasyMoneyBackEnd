package com.API.EasyMoney.BackEnd.Controllers;

import com.API.EasyMoney.BackEnd.Dtos.ReferenceDTO;
import com.API.EasyMoney.BackEnd.Services.ReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/reference")
public class ReferenceController {
    // Inject the ReferenceService
    @Autowired
    private ReferenceService referenceService;

    // Get all references
    @GetMapping
    public ResponseEntity<List<ReferenceDTO>> getAllReferences() {
        try {
            // If not exist references return not found
            if (referenceService.getAllReferences().isEmpty()) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok(referenceService.getAllReferences());
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Get reference by id
    @GetMapping("/{id}")
    public ResponseEntity<ReferenceDTO> getReferenceById(@PathVariable Long id) {
        try {
            // Get the reference by id
            ReferenceDTO referenceDTO = referenceService.getReferenceById(id);
            // If not exist reference return not found
            if (referenceDTO == null) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok(referenceDTO);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Create a new reference
    @PostMapping
    public ResponseEntity<ReferenceDTO> createReference(@RequestBody ReferenceDTO dto) {
        try {
            // Create the reference
            ReferenceDTO referenceDTO = referenceService.createReference(dto);
            // Return the reference
            return ResponseEntity.ok(referenceDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Update reference by id
    @PutMapping("/{id}")
    public ResponseEntity<ReferenceDTO> updateReference(@PathVariable Long id, @RequestBody ReferenceDTO dto) {
        try {
            //If not exist reference return not found
            if (referenceService.getReferenceById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            // Update the reference
            ReferenceDTO referenceDTO = referenceService.updateReference(id, dto);
            // Return the reference
            return ResponseEntity.ok(referenceDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Delete reference by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReference(@PathVariable Long id) {
        try {
            // If not exist reference return not found
            if (referenceService.getReferenceById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            // Delete the reference
            referenceService.deleteReference(id);
            // Return no content
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
