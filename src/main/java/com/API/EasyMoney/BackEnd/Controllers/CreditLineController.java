package com.API.EasyMoney.BackEnd.Controllers;

import com.API.EasyMoney.BackEnd.Dtos.CreditLineDTO;
import com.API.EasyMoney.BackEnd.Services.CreditLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/creditLine")
public class CreditLineController {
    // Inject the CreditLineService
    @Autowired
    private CreditLineService creditLineService;

    // Get all credit lines
    @GetMapping
    public ResponseEntity<List<CreditLineDTO>> getAllCreditLines() {
        try {
            // If not exist credit lines return not found
            if (creditLineService.getAllCreditLines().isEmpty()) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok(creditLineService.getAllCreditLines());
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Get credit line by id
    @GetMapping("/{id}")
    public ResponseEntity<CreditLineDTO> getCreditLineById(@PathVariable Long id) {
        try {
            // Get the credit line by id
            CreditLineDTO creditLineDTO = creditLineService.getCreditLineById(id);
            // If not exist credit line return not found
            if (creditLineDTO == null) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok(creditLineDTO);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Create a new credit line
    @PostMapping
    public ResponseEntity<CreditLineDTO> createCreditLine(@RequestBody CreditLineDTO dto) {
        try {
            // Create the credit line
            CreditLineDTO creditLineDTO = creditLineService.createCreditLine(dto);
            // Return the credit line
            return ResponseEntity.ok(creditLineDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Update credit line
    @PutMapping("/{id}")
    public ResponseEntity<CreditLineDTO> updateCreditLine(@PathVariable Long id, @RequestBody CreditLineDTO dto) {
        try {
            //  If not exist credit line return not found
            if (creditLineService.getCreditLineById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            // Update the credit line
            CreditLineDTO creditLineDTO = creditLineService.updateCreditLine(id, dto);
            // Return the credit line
            return ResponseEntity.ok(creditLineDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Delete credit line by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCreditLine(@PathVariable Long id) {
        try {
            // If not exist credit line return not found
            if (creditLineService.getCreditLineById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            // Delete the credit line
            creditLineService.deleteCreditLine(id);
            // Return no content
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
