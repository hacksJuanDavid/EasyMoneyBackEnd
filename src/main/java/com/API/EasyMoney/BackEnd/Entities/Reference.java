package com.API.EasyMoney.BackEnd.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "reference")
public class Reference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reference_id", nullable = false)
    private Long referenceId;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "city")
    private String city;

    @Column(name = "relationship")
    private String relationship;

    @Column(name = "type_reference")
    private String typeReference;

    // Relación con PersonalInformation (muchos a uno)
    @ManyToOne
    @JoinColumn(name = "personal_information_id")
    private PersonalInformation personalInformation;
}
