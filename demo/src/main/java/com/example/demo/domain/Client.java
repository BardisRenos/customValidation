package com.example.demo.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="client")
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String lastName;
    private String address;
    @Email
    private String email;
    private String nationality;
    private int age;
}
