package com.API.EasyMoney.BackEnd.Dtos;

import lombok.Data;

@Data
public class CreditLineDTO {
    private Long id;
    private String name;
    private Double minAmount;
    private Double maxAmount;
    private String maxTerm;
}
