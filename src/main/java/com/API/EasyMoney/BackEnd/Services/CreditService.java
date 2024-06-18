package com.API.EasyMoney.BackEnd.Services;

import com.API.EasyMoney.BackEnd.Converters.CreditConvert;
import com.API.EasyMoney.BackEnd.Dtos.CreditDTO;
import com.API.EasyMoney.BackEnd.Entities.Credit;
import com.API.EasyMoney.BackEnd.Entities.PersonalInformation;
import com.API.EasyMoney.BackEnd.Repositories.CreditRepository;
import com.API.EasyMoney.BackEnd.Repositories.PersonalInformationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreditService {
    // Inject class
    @Autowired
    private CreditConvert creditConvert;
    @Autowired
    private CreditRepository creditRepository;
    @Autowired
    private PersonalInformationRepository personalInformationRepository;

    // Get all credits
    public List<CreditDTO> getAllCredits() {
        // Get all credits
        List<Credit> creditList = creditRepository.findAll();
        // Convert the credits to DTO
        return creditConvert.convertToDtoList(creditList);
    }

    // Get credit by id
    public CreditDTO getCreditById(Long id) {
        // Get the credit by id
        Optional<Credit> creditOptional = creditRepository.findById(id);
        // Check if the credit exists
        if (creditOptional.isPresent()) {
            Credit credit = creditOptional.get();
            return creditConvert.convertToDto(credit);
        } else {
            return null; // Return null when no credit found
        }
    }

    // Save credit
    public CreditDTO createCredit(CreditDTO dto) {
        // Convert the credit DTO to entity
        Credit credit = creditConvert.convertToEntity(dto);
        // If the personal information id is not null
        if (dto.getPersonalInformationId() != null) {
            // Find the personal information by id
            Optional<PersonalInformation> personalInfoOptional = personalInformationRepository.findById(dto.getPersonalInformationId());
            // Check if the personal information exists
            if (personalInfoOptional.isPresent()) {
                PersonalInformation personalInformation = personalInfoOptional.get();
                credit.setPersonalInformation(personalInformation);
            }
        }
        // Save the credit
        creditRepository.save(credit);
        // Return the credit DTO
        return creditConvert.convertToDto(credit);
    }

    // Update credit
    public CreditDTO updateCredit(Long id, CreditDTO dto) {
        // Search for the existing credit by id
        Credit existingCredit = creditRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Credit not found with id: " + id));
        // Update the credit
        if(dto.getLineCredit() != null) existingCredit.setLineCredit(dto.getLineCredit());
        if(dto.getCreditAmount() != null) existingCredit.setCreditAmount(dto.getCreditAmount());
        if(dto.getCreditTerm() != null) existingCredit.setCreditTerm(dto.getCreditTerm());
        if(dto.getDescription() != null) existingCredit.setDescription(dto.getDescription());
        if(dto.getPersonalInformationId() != null) {
            Optional<PersonalInformation> personalInfoOptional = personalInformationRepository.findById(dto.getPersonalInformationId());
            if (personalInfoOptional.isPresent()) {
                existingCredit.setPersonalInformation(personalInfoOptional.get());
            } else {
                throw new EntityNotFoundException("Personal information not found with id: " + dto.getPersonalInformationId());
            }
        }
        // Save the credit
        Credit updatedCredit = creditRepository.save(existingCredit);
        // Return the updated credit
        return creditConvert.convertToDto(updatedCredit);
    }

    // Delete credit by id
    public void deleteCredit(Long id) {
        creditRepository.deleteById(id);
    }
}
