package com.API.EasyMoney.BackEnd.Services;

import com.API.EasyMoney.BackEnd.Dtos.PersonalInformationDTO;
import com.API.EasyMoney.BackEnd.Entities.PersonalInformation;
import com.API.EasyMoney.BackEnd.Converters.PersonalInformationConvert;
import com.API.EasyMoney.BackEnd.Repositories.PersonalInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonalInformationService {
    // Inject Class 
    @Autowired
    private PersonalInformationConvert personalInformationConvert;
    @Autowired
    private PersonalInformationRepository personalInformationRepository;

    // Get all personal information
    public List<PersonalInformationDTO> getAllPersonalInformation() {
        // Get all personal information
        List<PersonalInformation> personalInformationList = personalInformationRepository.findAll();

        // Convert the personal information to DTO
        return personalInformationConvert.convertToDtoList(personalInformationList);
    }

    // Get personal information by id
    public PersonalInformationDTO getPersonalInformationById(Long id) {
        // Get the personal information by id
        Optional<PersonalInformation> personalInfoOptional = personalInformationRepository.findById(id);
        // Check if the personal information exists
        if (personalInfoOptional.isPresent()) {
            PersonalInformation personalInfo = personalInfoOptional.get();
            // Convert the personal information to DTO
            return personalInformationConvert.convertToDto(personalInfo);
        } else {
            return null; // Return null when no personal information found
        }
    }

    // Save personal information
    public PersonalInformationDTO createPersonalInformation(PersonalInformationDTO dto) {
        // Convert the personal information DTO to entity
        PersonalInformation personalInformation = personalInformationConvert.convertToEntity(dto);

        // Save the personal information
        personalInformationRepository.save(personalInformation);

        // return the personal information
        return personalInformationConvert.convertToDto(personalInformation);
    }

    // Update personal information
    public PersonalInformationDTO updatePersonalInformation(Long id, PersonalInformationDTO dto) {
        // Check if the personal information exists
        PersonalInformation personalInformation = personalInformationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Personal information not found with id: " + id));

        // Convert the personal information DTO to entity
        PersonalInformation personalInformationUpdate = personalInformationConvert.convertToEntity(dto);
        personalInformationUpdate.setPersonalInformationId(personalInformation.getPersonalInformationId());

        // Save the personal information
        personalInformationRepository.save(personalInformationUpdate);

        // return the personal information
        return personalInformationConvert.convertToDto(personalInformationUpdate);
    }

    // Delete personal information by id
    public void deletePersonalInformation(Long id) {
        personalInformationRepository.deleteById(id);
    }
}
