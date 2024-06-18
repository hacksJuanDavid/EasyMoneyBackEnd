package com.API.EasyMoney.BackEnd.Controllers;

import com.API.EasyMoney.BackEnd.Dtos.PersonalInformationDTO;
import com.API.EasyMoney.BackEnd.Services.PersonalInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/personalInformation")
public class PersonalInformationController {
    // Inject the PersonalInformationService
    @Autowired
    private PersonalInformationService personalInformationService;

    // Get all personal information
    @GetMapping
    public ResponseEntity<List<PersonalInformationDTO>> getAllPersonalInformation() {
        try {
            // If not exist personal information return not found
            if (personalInformationService.getAllPersonalInformation().isEmpty()) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok(personalInformationService.getAllPersonalInformation());
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Get all personal information by id
    @GetMapping("/{id}")
    public ResponseEntity<PersonalInformationDTO> getPersonalInformationById(@PathVariable Long id) {
        try {
            // Get the personal information by id
            PersonalInformationDTO personalInformationDTO = personalInformationService.getPersonalInformationById(id);

            // If not exist personal information return not found
            if (personalInformationDTO == null) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok(personalInformationDTO);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Create a new personal information
    @PostMapping
    public ResponseEntity<PersonalInformationDTO> createPersonalInformation(@RequestBody PersonalInformationDTO dto) {
        try {
            // Create the personal information
            PersonalInformationDTO personalInformationDTO = personalInformationService.createPersonalInformation(dto);

            // Return the personal information
            return ResponseEntity.ok(personalInformationDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Update a personal information
    @PutMapping("/{id}")
    public ResponseEntity<PersonalInformationDTO> updatePersonalInformation(@PathVariable Long id, @RequestBody PersonalInformationDTO dto) {
        try {
            // If not exist personal information return not found
            if (personalInformationService.getPersonalInformationById(id) == null) {
                return ResponseEntity.notFound().build();
            }

            // Update the personal information
            PersonalInformationDTO personalInformationDTO = personalInformationService.updatePersonalInformation(id, dto);

            // Return the personal information
            return ResponseEntity.ok(personalInformationDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Delete a personal information
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersonalInformation(@PathVariable Long id) {
        try {
            // If not exist personal information return not found
            if (personalInformationService.getPersonalInformationById(id) == null) {
                return ResponseEntity.notFound().build();
            }

            // Delete the personal information
            personalInformationService.deletePersonalInformation(id);

            // Return the personal information
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
