package com.clothshop.management.Supplier_Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Supplier name cannot be empty")
    @Size(min = 3, max = 100, message = "Name should be between 3 and 100 characters")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Please provide a valid email address")
    @Column(unique = true, nullable = false)
    private String email;

    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Phone number must be between 10 to 15 digits")
    private String phone;

    @NotBlank(message = "Company name cannot be empty")
    private String company;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
