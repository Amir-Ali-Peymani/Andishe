package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message="is required")
    @Column(name = "name")
    @Size(min=2, max=20)
    @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "must not contain numbers or special characters")
    private String name;

    @NotNull(message = "is required")
    @Size(min=2, max=20)
    @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "must not contain numbers or special characters")
    @Column(name = "last_name")
    private String lastName;

    @NotNull(message = "is required")
    @Min(value=15, message="should not be less than 15 years old")
    @Max(value=100, message="should not be more than 100 years old")
    @Column(name = "age")
    private int age;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    @Valid
    private Account account;

}
