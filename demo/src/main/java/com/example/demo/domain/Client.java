package com.example.demo.domain;

import com.example.demo.validation.ValidClient;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name="client")
@NoArgsConstructor
@AllArgsConstructor
@ValidClient
public class Client {

    @Id
    @GeneratedValue(strategy=IDENTITY)
    private Long id;
    @NotBlank(message = "The name need to valid")
    private String name;
    @NotBlank(message = "The last name need to be valid")
    private String lastName;
    private String address;
    @Email(message = "Invalid email format")
    private String email;
    private String nationality;
    private int age;
}
