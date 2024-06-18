package com.API.EasyMoney.BackEnd.Converters;

import com.API.EasyMoney.BackEnd.Dtos.CreditDTO;
import com.API.EasyMoney.BackEnd.Entities.Credit;
import com.API.EasyMoney.BackEnd.Entities.PersonalInformation;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CreditConvert {
    // Convert the credit DTO to entity
    public Credit convertToEntity(CreditDTO dto) {
        // Create the credit entity
        Credit credit = new Credit();
        credit.setLineCredit(dto.getLineCredit());
        credit.setCreditAmount(dto.getCreditAmount());
        credit.setCreditTerm(dto.getCreditTerm());
        credit.setDescription(dto.getDescription());
        // Check if the personal information id is not null
        if (dto.getPersonalInformationId() != null) {
            PersonalInformation personalInformation = new PersonalInformation();
            personalInformation.setPersonalInformationId(dto.getPersonalInformationId());
            credit.setPersonalInformation(personalInformation);
        }
        return credit;
    }

    // Convert the credit to DTO
    public CreditDTO convertToDto(Credit credit) {
        // Create the credit DTO
        CreditDTO dto = new CreditDTO();
        dto.setId(credit.getCreditId());
        dto.setLineCredit(credit.getLineCredit());
        dto.setCreditAmount(credit.getCreditAmount());
        dto.setCreditTerm(credit.getCreditTerm());
        dto.setDescription(credit.getDescription());
        dto.setPersonalInformationId(credit.getPersonalInformation().getPersonalInformationId());
        return dto;
    }

    // Convert the credit list to DTO
    public List<CreditDTO> convertToDtoList(List<Credit> creditList) {
        return creditList.stream().map(this::convertToDto).collect(Collectors.toList());
    }
}
