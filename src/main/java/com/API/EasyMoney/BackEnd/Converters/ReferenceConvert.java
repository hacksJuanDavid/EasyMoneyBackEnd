package com.API.EasyMoney.BackEnd.Converters;

import com.API.EasyMoney.BackEnd.Dtos.ReferenceDTO;
import com.API.EasyMoney.BackEnd.Entities.PersonalInformation;
import com.API.EasyMoney.BackEnd.Entities.Reference;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReferenceConvert {
    // Convert the reference DTO to entity
    public Reference convertToEntity(ReferenceDTO dto) {
        // Create the reference entity
        Reference reference = new Reference();
        reference.setEmail(dto.getEmail());
        reference.setName(dto.getName());
        reference.setLastName(dto.getLastName());
        reference.setAddress(dto.getAddress());
        reference.setPhone(dto.getPhone());
        reference.setCity(dto.getCity());
        reference.setRelationship(dto.getRelationship());
        reference.setTypeReference(dto.getTypeReference());
        // Check if the personal information id is not null
        if (dto.getPersonalInformationId() != null) {
            PersonalInformation personalInformation = new PersonalInformation();
            personalInformation.setPersonalInformationId(dto.getPersonalInformationId());
            reference.setPersonalInformation(personalInformation);
        }
        return reference;
    }

    // Convert the reference to DTO
    public ReferenceDTO convertToDto(Reference reference) {
        // Create the reference DTO
        ReferenceDTO dto = new ReferenceDTO();
        dto.setId(reference.getReferenceId());
        dto.setEmail(reference.getEmail());
        dto.setName(reference.getName());
        dto.setLastName(reference.getLastName());
        dto.setAddress(reference.getAddress());
        dto.setPhone(reference.getPhone());
        dto.setCity(reference.getCity());
        dto.setRelationship(reference.getRelationship());
        dto.setTypeReference(reference.getTypeReference());
        dto.setPersonalInformationId(reference.getPersonalInformation().getPersonalInformationId());
        return dto;
    }

    // Convert the reference list to DTO
    public List<ReferenceDTO> convertToDtoList(List<Reference> referenceList) {
        return referenceList.stream().map(this::convertToDto).collect(Collectors.toList());
    }
}
