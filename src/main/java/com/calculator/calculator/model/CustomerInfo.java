package com.calculator.calculator.model;

import com.calculator.calculator.dto.Carwash.CarwashRegisterDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity(name = "CustomerInfo")
public class CustomerInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer id;

    @Column(name="FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "MIDDLE_NAME")
    private String middleName;

    @Column(name = "CONTACT_NO")
    private String contactNo;

    @Column(name = "EMAIL")
    private String email;

    public CustomerInfo(CarwashRegisterDTO carwashRegisterDTO) {
        this.firstName = carwashRegisterDTO.getFirstName();
        this.lastName = carwashRegisterDTO.getLastName();
        this.middleName = carwashRegisterDTO.getMiddleName();
        this.contactNo = carwashRegisterDTO.getContactNo();
        this.email = carwashRegisterDTO.getEmail();
    }
}
