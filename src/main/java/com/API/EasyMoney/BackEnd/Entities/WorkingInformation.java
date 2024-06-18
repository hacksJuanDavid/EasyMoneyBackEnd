package com.API.EasyMoney.BackEnd.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table(name = "working_information")
public class WorkingInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "working_information_id", nullable = false)
    private Long workingInformationId;

    @Column(name = "nit_company", unique = true)
    private Long nitCompany;

    @Column(name = "name_company")
    private String nameCompany;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "phone")
    private String phone;

    @Column(name = "position")
    private String position;

    @Column(name = "salary")
    private Double salary;

    @Column(name = "date_admission", columnDefinition = "DATE")
    private LocalDate dateAdmission;

    // Relación con PersonalInformation (uno a uno)
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "personal_information_id", referencedColumnName = "personal_information_id")
    private PersonalInformation personalInformation;
}
