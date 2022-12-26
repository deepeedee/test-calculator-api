package com.calculator.calculator.enums;

import com.calculator.calculator.dto.Calculate.CalculateIntegerDTO;
import com.calculator.calculator.dto.Operation.OperationDTO;
import com.calculator.calculator.exception.InvalidOperationException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.platform.commons.util.StringUtils;

import java.util.stream.Stream;
@Slf4j
@Getter
@RequiredArgsConstructor
public enum Operation {

    ADDITION("Addition"),
    SUBTRACTION("Subtraction"),
    MULTIPLICATION("Multiplication"),
    DIVISION("Division");

    private final String value;

    public static Stream<Operation> stream() {
        return Stream.of(Operation.values());
    }

    public String checkOperation(String operationSubtext) throws InvalidOperationException {
        if(!StringUtils.isBlank(operationSubtext) && (this.value.substring(0,2).equalsIgnoreCase(operationSubtext)
                || this.value.equalsIgnoreCase(operationSubtext))){
            return this.value;
        }else {
            throw new InvalidOperationException();
        }
    }

    public boolean isOperation(String operationSubtext) throws InvalidOperationException {
        if(!StringUtils.isBlank(operationSubtext) && (this.value.substring(0,2).equalsIgnoreCase(operationSubtext)
                || this.value.equalsIgnoreCase(operationSubtext))){
            return true;
        }else {
            return false;
        }
    }

}
