package com.API.EasyMoney.BackEnd.Converters;

import com.API.EasyMoney.BackEnd.Dtos.CreditLineDTO;
import com.API.EasyMoney.BackEnd.Entities.CreditLine;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CreditLineConvert {
    // Convert CreditLineDTO to CreditLine
    public CreditLine convertToEntity(CreditLineDTO creditLineDTO) {
        CreditLine creditLine = new CreditLine();
        creditLine.setName(creditLineDTO.getName());
        creditLine.setMinAmount(creditLineDTO.getMinAmount());
        creditLine.setMaxAmount(creditLineDTO.getMaxAmount());
        creditLine.setMaxTerm(creditLineDTO.getMaxTerm());
        return creditLine;
    }

    // Convert CreditLine to CreditLineDTO
    public CreditLineDTO convertToDTO(CreditLine creditLine) {
        CreditLineDTO creditLineDTO = new CreditLineDTO();
        creditLineDTO.setId(creditLine.getCreditLineId());
        creditLineDTO.setName(creditLine.getName());
        creditLineDTO.setMinAmount(creditLine.getMinAmount());
        creditLineDTO.setMaxAmount(creditLine.getMaxAmount());
        creditLineDTO.setMaxTerm(creditLine.getMaxTerm());
        return creditLineDTO;
    }

    // Convert List<CreditLine> 
    public List<CreditLineDTO> convertToDTOList(List<CreditLine> creditLines) {
        return creditLines.stream().map(this::convertToDTO).collect(Collectors.toList());
    }
}
