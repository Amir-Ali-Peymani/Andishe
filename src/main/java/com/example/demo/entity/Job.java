package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "job")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "cost")
    @NotNull(message = "cost is essential")
    private double cost;

    @Column(name = "job_description")
    @NotNull(message = "job description required")
    private String jobDescription;

    @Column(name = "experience_years")
    @NotNull(message = "experience years required")
    private int experienceYears;


    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "account_id")
    private Account account;
}
