package com.calculator.calculator.dto.Operation;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@RequiredArgsConstructor
public class OperationDTO {

    private String operation;

    private boolean isValid;

}
