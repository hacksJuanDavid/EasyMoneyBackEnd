package com.API.EasyMoney.BackEnd.Services;

import com.API.EasyMoney.BackEnd.Converters.WorkingInformationConvert;
import com.API.EasyMoney.BackEnd.Entities.PersonalInformation;
import com.API.EasyMoney.BackEnd.Entities.WorkingInformation;
import com.API.EasyMoney.BackEnd.Dtos.WorkingInformationDTO;
import com.API.EasyMoney.BackEnd.Repositories.PersonalInformationRepository;
import com.API.EasyMoney.BackEnd.Repositories.WorkingInformationRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkingInformationService {
    // Inject Class
    @Autowired
    private WorkingInformationConvert workingInformationConvert;
    @Autowired
    private WorkingInformationRepository workingInformationRepository;
    @Autowired
    private PersonalInformationRepository personalInformationRepository;

    // Get all working information
    public List<WorkingInformationDTO> getAllWorkingInformation() {
        // Get all working information
        List<WorkingInformation> workingInformationList = workingInformationRepository.findAll();
        // Convert the working information to DTO
        return workingInformationConvert.convertToDtoList(workingInformationList);
    }

    // Get working information by id
    public WorkingInformationDTO getWorkingInformationById(Long id) {
        // Get the working information by id
        Optional<WorkingInformation> workingInfoOptional = workingInformationRepository.findById(id);
        // Check if the working information exists
        if (workingInfoOptional.isPresent()) {
            WorkingInformation workingInfo = workingInfoOptional.get();
            return workingInformationConvert.convertToDto(workingInfo);
        } else {
            return null; // Return null when no working information found
        }
    }

    // Save working information
    public WorkingInformationDTO createWorkingInformation(WorkingInformationDTO dto) {
        // Convert the working information DTO to entity
        WorkingInformation workingInformation = workingInformationConvert.convertToEntity(dto);
        // If the personal information id is not null
        if (dto.getPersonalInformationId() != null) {
            // Find the personal information by id
            Optional<PersonalInformation> personalInfoOptional = personalInformationRepository.findById(dto.getPersonalInformationId());
            // Check if the personal information exists
            if (personalInfoOptional.isPresent()) {
                PersonalInformation personalInformation = personalInfoOptional.get();
                workingInformation.setPersonalInformation(personalInformation);
            }
        }
        // Save the working information
        workingInformationRepository.save(workingInformation);
        // return the working information
        return workingInformationConvert.convertToDto(workingInformation);
    }

    // Update working information
    public WorkingInformationDTO updateWorkingInformation(Long id, WorkingInformationDTO dto) {
        // Search for the existing working information by id
        WorkingInformation existingWorkingInformation = workingInformationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Working information not found with id: " + id));
        // Update the working information with the new data
        if (dto.getNitCompany() != null) existingWorkingInformation.setNitCompany(dto.getNitCompany());
        if (dto.getNameCompany() != null) existingWorkingInformation.setNameCompany(dto.getNameCompany());
        if (dto.getAddress() != null) existingWorkingInformation.setAddress(dto.getAddress());
        if (dto.getCity() != null) existingWorkingInformation.setCity(dto.getCity());
        if (dto.getPhone() != null) existingWorkingInformation.setPhone(dto.getPhone());
        if (dto.getPosition() != null) existingWorkingInformation.setPosition(dto.getPosition());
        if (dto.getSalary() != null) existingWorkingInformation.setSalary(dto.getSalary());
        if (dto.getDateAdmission() != null) existingWorkingInformation.setDateAdmission(dto.getDateAdmission());
        // If the personal information id is not null update the personal information
        if (dto.getPersonalInformationId() != null) {
            Optional<PersonalInformation> personalInfoOptional = personalInformationRepository.findById(dto.getPersonalInformationId());
            if (personalInfoOptional.isPresent()) {
                existingWorkingInformation.setPersonalInformation(personalInfoOptional.get());
            } else {
                throw new EntityNotFoundException("Personal information not found with id: " + dto.getPersonalInformationId());
            }
        }
        // Save the updated working information
        WorkingInformation updatedWorkingInformation = workingInformationRepository.save(existingWorkingInformation);
        // Return the updated working information
        return workingInformationConvert.convertToDto(updatedWorkingInformation);
    }

    // Delete working information by id
    public void deleteWorkingInformation(Long id) {
        workingInformationRepository.deleteById(id);
    }
}
