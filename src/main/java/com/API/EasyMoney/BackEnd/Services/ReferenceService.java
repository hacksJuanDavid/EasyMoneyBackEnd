package com.API.EasyMoney.BackEnd.Services;

import com.API.EasyMoney.BackEnd.Converters.ReferenceConvert;
import com.API.EasyMoney.BackEnd.Dtos.ReferenceDTO;
import com.API.EasyMoney.BackEnd.Entities.PersonalInformation;
import com.API.EasyMoney.BackEnd.Entities.Reference;
import com.API.EasyMoney.BackEnd.Repositories.PersonalInformationRepository;
import com.API.EasyMoney.BackEnd.Repositories.ReferenceRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReferenceService {
    // Inject Class
    @Autowired
    private ReferenceConvert referenceConvert;
    @Autowired
    private ReferenceRepository referenceRepository;
    @Autowired
    private PersonalInformationRepository personalInformationRepository;

    // Get all references
    public List<ReferenceDTO> getAllReferences() {
        // Get all references
        List<Reference> referenceList = referenceRepository.findAll();
        // Convert the references to DTO
        return referenceConvert.convertToDtoList(referenceList);
    }

    // Get reference by id
    public ReferenceDTO getReferenceById(Long id) {
        // Get the reference by id
        Optional<Reference> referenceOptional = referenceRepository.findById(id);
        // Check if the reference exists
        if (referenceOptional.isPresent()) {
            Reference reference = referenceOptional.get();
            return referenceConvert.convertToDto(reference);
        } else {
            return null; // Return null when no reference found
        }
    }

    // Save reference
    public ReferenceDTO createReference(ReferenceDTO dto) {
        // Convert the reference DTO to entity
        Reference reference = referenceConvert.convertToEntity(dto);
        // If the personal information id is not null
        if (dto.getPersonalInformationId() != null) {
            // Find the personal information by id
            Optional<PersonalInformation> personalInfoOptional = personalInformationRepository.findById(dto.getPersonalInformationId());
            // Check if the personal information exists
            if (personalInfoOptional.isPresent()) {
                PersonalInformation personalInformation = personalInfoOptional.get();
                reference.setPersonalInformation(personalInformation);
            }
        }
        // Save the reference
        referenceRepository.save(reference);
        // Return the reference DTO
        return referenceConvert.convertToDto(reference);
    }

    // Update reference
    public ReferenceDTO updateReference(Long id, ReferenceDTO dto) {
        // Search for the existing reference by id
        Reference existingReference = referenceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Reference not found"));
        // Update the reference with the new data
        if (dto.getEmail() != null) existingReference.setEmail(dto.getEmail());
        if (dto.getName() != null) existingReference.setName(dto.getName());
        if (dto.getLastName() != null) existingReference.setLastName(dto.getLastName());
        if (dto.getAddress() != null) existingReference.setAddress(dto.getAddress());
        if (dto.getPhone() != null) existingReference.setPhone(dto.getPhone());
        if (dto.getCity() != null) existingReference.setCity(dto.getCity());
        if (dto.getRelationship() != null) existingReference.setRelationship(dto.getRelationship());
        if (dto.getTypeReference() != null) existingReference.setTypeReference(dto.getTypeReference());
        // Check if the personal information id is not null
        if (dto.getPersonalInformationId() != null) {
            Optional<PersonalInformation> personalInfoOptional = personalInformationRepository.findById(dto.getPersonalInformationId());
            if (personalInfoOptional.isPresent()) {
                existingReference.setPersonalInformation(personalInfoOptional.get());
            } else {
                throw new EntityNotFoundException("Personal information not found with id: " + dto.getPersonalInformationId());
            }
        }
        // Save the updated working information
        Reference updatedReference = referenceRepository.save(existingReference);
        // Return the updated working information
        return referenceConvert.convertToDto(updatedReference);
    }

    // Delete reference by id
    public void deleteReference(Long id) {
        referenceRepository.deleteById(id);
    }
}
