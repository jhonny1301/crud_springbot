package com.example.cruddao.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "informacion")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Informacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeID;

    @Column(name = "firstname", nullable = false)
    private String firstName;

    @Column(name = "lastname", nullable = false)
    private String lastName;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "email", nullable = false, unique = true)
    private String email;
}
