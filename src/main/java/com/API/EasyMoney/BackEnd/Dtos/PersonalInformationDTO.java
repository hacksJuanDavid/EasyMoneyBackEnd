package com.API.EasyMoney.BackEnd.Dtos;

import lombok.Data;

import java.util.List;

@Data
public class PersonalInformationDTO {
    private Long id;
    private String typeDocument;
    private String documentNumber;
    private String name;
    private String lastName;
    private String residence;
    private String city;
    private String phone;
    private WorkingInformationDTO workingInformation;
    private List<ReferenceDTO> reference;
    private List<CreditDTO> credit;
}
