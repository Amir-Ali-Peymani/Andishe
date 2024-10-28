package com.example.demo.entity;

import com.example.demo.enumeration.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "account")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message="is required")
    @Column(unique = true, name = "user_name")
    @Pattern(regexp = "^[\\w\\W]*$")
    private String username;

    @NotNull(message= "email is required")
    @Column(unique = true, name = "email")
    @Pattern(regexp = "^[\\w-.]+@[\\w-]+\\.com$", message = "Email must be valid and contain @,also end with .com")
    private String email;

    @NotNull(message="is required")
    @Column(name = "password")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!\"'()\\[\\]{};:<>.,?/~`\\-_])[A-Za-z\\d@#$%^&+=!\"'()\\[\\]{};:<>.,?/~`\\-_]{8,}$",
            message = "Password must contain at least one uppercase letter, one lowercase letter, one digit, one special " +
                    "character, and be at least 8 characters long.")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    @NotNull
    private Role role;

    @OneToMany(mappedBy = "account"
            ,cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    private List<Job> jobs;

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    private Person person;
}
