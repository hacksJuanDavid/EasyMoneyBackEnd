package com.API.EasyMoney.BackEnd.Controllers;

import com.API.EasyMoney.BackEnd.Dtos.CreditDTO;
import com.API.EasyMoney.BackEnd.Services.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/credit")
public class CreditController {
    // Inject the CreditService
    @Autowired
    private CreditService creditService;

    // Get all credits
    @GetMapping
    public ResponseEntity<List<CreditDTO>> getAllCredits() {
        try {
            // If not exist credits return not found
            if (creditService.getAllCredits().isEmpty()) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok(creditService.getAllCredits());
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Get credit by id
    @GetMapping("/{id}")
    public ResponseEntity<CreditDTO> getCreditById(@PathVariable Long id) {
        try {
            // Get the credit by id
            CreditDTO creditDTO = creditService.getCreditById(id);
            // If not exist credit return not found
            if (creditDTO == null) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok(creditDTO);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Create a new credit
    @PostMapping
    public ResponseEntity<CreditDTO> createCredit(@RequestBody CreditDTO dto) {
        try {
            // Create the credit
            CreditDTO creditDTO = creditService.createCredit(dto);
            // Return the credit
            return ResponseEntity.ok(creditDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Update credit by id
    @PutMapping("/{id}")
    public ResponseEntity<CreditDTO> updateCredit(@PathVariable Long id, @RequestBody CreditDTO dto) {
        try {
            // If not exist credit return not found
            if (creditService.getCreditById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            // Update the credit
            CreditDTO creditDTO = creditService.updateCredit(id, dto);
            // Return the credit
            return ResponseEntity.ok(creditDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Delete credit by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCredit(@PathVariable Long id) {
        try {
            // If not exist credit return not found
            if (creditService.getCreditById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            // Delete the credit
            creditService.deleteCredit(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
