package com.API.EasyMoney.BackEnd.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "credit")
public class Credit {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "credit_id", nullable = false)
    private Long creditId;
    @Column(name = "line_credit")
    private String lineCredit;
    @Column(name = "credit_amount")
    private Double creditAmount;
    @Column(name = "credit_term")
    private String creditTerm;
    @Column(name = "description")
    private String description;

    // Relación con PersonalInformation (muchos a uno)
    @ManyToOne
    @JoinColumn(name = "personal_information_id")
    private PersonalInformation personalInformation;
}
