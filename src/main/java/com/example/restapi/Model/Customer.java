package com.example.restapi.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Customer_Name",nullable = false,length = 50)
    private String CustomerName;
    @Column(name = "Customer_Email",nullable = false, length = 50)
    private String CustomerEmail;
    @Column(name = "Customer_Password",nullable = false,length = 50)
    private String CustomerPassword;
}
