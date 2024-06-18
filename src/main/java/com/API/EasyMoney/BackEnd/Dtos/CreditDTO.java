package com.API.EasyMoney.BackEnd.Dtos;

import lombok.Data;

@Data
public class CreditDTO {
    private Long id;
    private String lineCredit;
    private Double creditAmount;
    private String creditTerm;
    private String description;
    private Long personalInformationId;
}
