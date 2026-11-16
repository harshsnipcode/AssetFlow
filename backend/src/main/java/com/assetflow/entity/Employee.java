package com.assetflow.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity @Table(name = "employees", indexes = @Index(name = "idx_employee_email", columnList = "email"))
@Getter @Setter @NoArgsConstructor
public class Employee {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(name = "employee_code", nullable = false, unique = true) private String employeeCode;
    @Column(nullable = false) private String fullName;
    @Column(nullable = false, unique = true) private String email;
    private String department;
    private String designation;
    private LocalDate joiningDate;
    @Column(nullable = false) private boolean active = true;
}
