package com.API.EasyMoney.BackEnd.Services;

import com.API.EasyMoney.BackEnd.Converters.CreditLineConvert;
import com.API.EasyMoney.BackEnd.Dtos.CreditLineDTO;
import com.API.EasyMoney.BackEnd.Entities.CreditLine;
import com.API.EasyMoney.BackEnd.Repositories.CreditLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreditLineService {
    // Inject class
    @Autowired
    private CreditLineConvert creditLineConvert;
    @Autowired
    private CreditLineRepository creditLineRepository;

    // Get all credit lines
    public List<CreditLineDTO> getAllCreditLines() {
        // Get all credit lines
        List<CreditLine> creditLines = creditLineRepository.findAll();
        // Convert to DTO
        return creditLineConvert.convertToDTOList(creditLines);
    }

    // Get credit line by id
    public CreditLineDTO getCreditLineById(Long id) {
        // Get credit line by id
        Optional<CreditLine> creditLineOptional = creditLineRepository.findById(id);
        // Check if the credit line exists
        if (creditLineOptional.isPresent()) {
            CreditLine creditLine = creditLineOptional.get();
            return creditLineConvert.convertToDTO(creditLine);
        } else {
            return null; // Return null when no credit line found
        }
    }

    // Save credit line
    public CreditLineDTO createCreditLine(CreditLineDTO dto) {
        // Convert the credit line DTO to entity
        CreditLine creditLine = creditLineConvert.convertToEntity(dto);
        // If the credit line id is not null
        if (dto.getId() != null) {
            // Find the credit line by id
            Optional<CreditLine> creditLineOptional = creditLineRepository.findById(dto.getId());
            // Check if the credit line exists
            if (creditLineOptional.isPresent()) {
                CreditLine creditLine1 = creditLineOptional.get();
                creditLine1.setName(creditLine.getName());
            }
        }
        // Save the credit line
        creditLineRepository.save(creditLine);
        // Return the credit line dto
        return creditLineConvert.convertToDTO(creditLine);
    }

    // Update credit line
    public CreditLineDTO updateCreditLine(Long id, CreditLineDTO dto) {
        // Search  for the exiting credit line by id
        Optional<CreditLine> creditLineOptional = creditLineRepository.findById(id);
        // Check if the credit line exists
        if (creditLineOptional.isPresent()) {
            CreditLine creditLine = creditLineOptional.get();
            creditLine.setName(dto.getName());
            creditLine.setMinAmount(dto.getMinAmount());
            creditLine.setMaxAmount(dto.getMaxAmount());
            creditLine.setMaxTerm(dto.getMaxTerm());
            // Save the credit line
            creditLineRepository.save(creditLine);
            // Return the credit line dto
            return creditLineConvert.convertToDTO(creditLine);
        } else {
            return null; // Return null when no credit line found
        }
    }

    // Delete credit line by id
    public void deleteCreditLine(Long id) {
        creditLineRepository.deleteById(id);
    }
}
