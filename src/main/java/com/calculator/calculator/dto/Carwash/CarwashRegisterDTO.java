package com.calculator.calculator.dto.Carwash;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@RequiredArgsConstructor
public class CarwashRegisterDTO {

    private String firstName;
    private String lastName;
    private String middleName;
    private String contactNo;
    private String email;

}
