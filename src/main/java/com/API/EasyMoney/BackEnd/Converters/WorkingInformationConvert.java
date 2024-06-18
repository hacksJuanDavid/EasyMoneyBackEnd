package com.API.EasyMoney.BackEnd.Converters;

import com.API.EasyMoney.BackEnd.Dtos.WorkingInformationDTO;
import com.API.EasyMoney.BackEnd.Entities.PersonalInformation;
import com.API.EasyMoney.BackEnd.Entities.WorkingInformation;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class WorkingInformationConvert {
    // Convert the working information DTO to entity
    public WorkingInformation convertToEntity(WorkingInformationDTO dto) {
        // Create the working information entity        
        WorkingInformation workingInfo = new WorkingInformation();
        workingInfo.setNitCompany(dto.getNitCompany());
        workingInfo.setNameCompany(dto.getNameCompany());
        workingInfo.setAddress(dto.getAddress());
        workingInfo.setCity(dto.getCity());
        workingInfo.setPhone(dto.getPhone());
        workingInfo.setPosition(dto.getPosition());
        workingInfo.setSalary(dto.getSalary());
        workingInfo.setDateAdmission(dto.getDateAdmission());
        // Check if the personal information id is not null
        if (dto.getPersonalInformationId() != null) {
            PersonalInformation personalInformation = new PersonalInformation();
            personalInformation.setPersonalInformationId(dto.getPersonalInformationId());
            workingInfo.setPersonalInformation(personalInformation);
        }
        return workingInfo;
    }

    // Convert the working information to DTO
    public WorkingInformationDTO convertToDto(WorkingInformation workingInformation) {
        WorkingInformationDTO dto = new WorkingInformationDTO();
        dto.setId(workingInformation.getWorkingInformationId());
        dto.setNitCompany(workingInformation.getNitCompany());
        dto.setNameCompany(workingInformation.getNameCompany());
        dto.setAddress(workingInformation.getAddress());
        dto.setCity(workingInformation.getCity());
        dto.setPhone(workingInformation.getPhone());
        dto.setPosition(workingInformation.getPosition());
        dto.setSalary(workingInformation.getSalary());
        dto.setDateAdmission(workingInformation.getDateAdmission());
        dto.setPersonalInformationId(workingInformation.getPersonalInformation().getPersonalInformationId());
        return dto;
    }

    // Convert the working information list to DTO
    public List<WorkingInformationDTO> convertToDtoList(List<WorkingInformation> workingInfoList) {
        return workingInfoList.stream().map(this::convertToDto).collect(Collectors.toList());
    }
}
