package com.API.EasyMoney.BackEnd.Dtos;

import java.time.LocalDate;

import lombok.Data;

@Data
public class WorkingInformationDTO {
    private Long id;
    private Long nitCompany;
    private String nameCompany;
    private String address;
    private String city;
    private String phone;
    private String position;
    private Double salary;
    private LocalDate dateAdmission;
    private Long personalInformationId;
}
