package com.API.EasyMoney.BackEnd.Dtos;

import lombok.Data;

@Data
public class ReferenceDTO {
    private Long id;
    private String email;
    private String name;
    private String lastName;
    private String address;
    private String phone;
    private String city;
    private String relationship;
    private String typeReference;
    private Long personalInformationId;
}
