package com.API.EasyMoney.BackEnd.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "credit_line")
public class CreditLine {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "credit_line_id", nullable = false)
    private Long creditLineId;
    @Column(name = "name")
    private String name;
    @Column(name = "min_amount")
    private Double minAmount;
    @Column(name = "max_amount")
    private Double maxAmount;
    @Column(name = "max_term")
    private String maxTerm;
}
