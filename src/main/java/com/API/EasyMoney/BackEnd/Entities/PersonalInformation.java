package com.API.EasyMoney.BackEnd.Entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "personal_information")
public class PersonalInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personal_information_id", nullable = false)
    private Long personalInformationId;

    @Column(name = "type_document")
    private String typeDocument;

    @Column(name = "document_number", unique = true)
    private String documentNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "residence")
    private String residence;

    @Column(name = "city")
    private String city;

    @Column(name = "phone")
    private String phone;

    // Relación con WorkingInformation (uno a uno)
    @OneToOne(mappedBy = "personalInformation", cascade = CascadeType.ALL)
    private WorkingInformation workingInformation;

    // Relación con Reference (uno a muchos)
    @OneToMany(mappedBy = "personalInformation", cascade = CascadeType.ALL)
    private List<Reference> references;

    // Relación con Credit (uno a muchos)
    @OneToMany(mappedBy = "personalInformation", cascade = CascadeType.ALL)
    private List<Credit> credits;
}
