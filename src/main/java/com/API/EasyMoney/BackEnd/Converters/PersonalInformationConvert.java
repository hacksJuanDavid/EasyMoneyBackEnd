package com.API.EasyMoney.BackEnd.Converters;

import com.API.EasyMoney.BackEnd.Dtos.CreditDTO;
import com.API.EasyMoney.BackEnd.Dtos.PersonalInformationDTO;
import com.API.EasyMoney.BackEnd.Dtos.ReferenceDTO;
import com.API.EasyMoney.BackEnd.Dtos.WorkingInformationDTO;
import com.API.EasyMoney.BackEnd.Entities.Credit;
import com.API.EasyMoney.BackEnd.Entities.PersonalInformation;
import com.API.EasyMoney.BackEnd.Entities.Reference;
import com.API.EasyMoney.BackEnd.Entities.WorkingInformation;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class PersonalInformationConvert {
    // Convert the personal information DTO to entity
    public PersonalInformation convertToEntity(PersonalInformationDTO dto) {
        // Create the personal information entity
        PersonalInformation personalInfo = new PersonalInformation();
        personalInfo.setTypeDocument(dto.getTypeDocument());
        personalInfo.setDocumentNumber(dto.getDocumentNumber());
        personalInfo.setName(dto.getName());
        personalInfo.setLastName(dto.getLastName());
        personalInfo.setResidence(dto.getResidence());
        personalInfo.setCity(dto.getCity());
        personalInfo.setPhone(dto.getPhone());
        return personalInfo;
    }

    // Convert the personal information to DTO
    public PersonalInformationDTO convertToDto(PersonalInformation personalInfo) {
        // Create the personal information DTO
        PersonalInformationDTO dto = new PersonalInformationDTO();
        dto.setId(personalInfo.getPersonalInformationId());
        dto.setTypeDocument(personalInfo.getTypeDocument());
        dto.setDocumentNumber(personalInfo.getDocumentNumber());
        dto.setName(personalInfo.getName());
        dto.setLastName(personalInfo.getLastName());
        dto.setResidence(personalInfo.getResidence());
        dto.setCity(personalInfo.getCity());
        dto.setPhone(personalInfo.getPhone());
        // Check if the personal information has working information
        if (personalInfo.getWorkingInformation() != null) {
            WorkingInformationDTO workingInfoDTO = getWorkingInformationDTO(personalInfo);
            // Assigned the working information to the personal information DTO
            dto.setWorkingInformation(workingInfoDTO);
        }
        // Check if the personal information has references
        if (personalInfo.getReferences() != null) {
            List<ReferenceDTO> referenceDTO = getReferenceDTO(personalInfo);
            // Assigned the references to the personal information DTO
            dto.setReference(referenceDTO);
        }
        // Check if the personal information has credits
        if (personalInfo.getCredits() != null) {
            List<CreditDTO> creditDTO = getCreditDTO(personalInfo);
            // Assigned the credits to the personal information DTO
            dto.setCredit(creditDTO);
        }
        return dto;
    }

    // Convert the personal information list to DTO
    public List<PersonalInformationDTO> convertToDtoList(List<PersonalInformation> personalInfoList) {
        return personalInfoList.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    // Get the working information DTO
    private static WorkingInformationDTO getWorkingInformationDTO(PersonalInformation personalInfo) {
        WorkingInformation workingInfo = personalInfo.getWorkingInformation();
        WorkingInformationDTO dto = new WorkingInformationDTO();
        dto.setId(workingInfo.getWorkingInformationId());
        dto.setNitCompany(workingInfo.getNitCompany());
        dto.setNameCompany(workingInfo.getNameCompany());
        dto.setAddress(workingInfo.getAddress());
        dto.setCity(workingInfo.getCity());
        dto.setPhone(workingInfo.getPhone());
        dto.setPosition(workingInfo.getPosition());
        dto.setSalary(workingInfo.getSalary());
        dto.setDateAdmission(workingInfo.getDateAdmission());
        dto.setPersonalInformationId(workingInfo.getPersonalInformation().getPersonalInformationId());
        return dto;
    }

    // Get the reference DTO
    private static List<ReferenceDTO> getReferenceDTO(PersonalInformation personalInfo) {
        List<Reference> referenceList = personalInfo.getReferences();
        ReferenceConvert referenceConvert = new ReferenceConvert();
        return referenceConvert.convertToDtoList(referenceList);
    }

    // Get the credit DTO
    private static List<CreditDTO> getCreditDTO(PersonalInformation personalInfo) {
        List<Credit> creditList = personalInfo.getCredits();
        CreditConvert creditConvert = new CreditConvert();
        return creditConvert.convertToDtoList(creditList);
    }
}
