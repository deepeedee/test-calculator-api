package com.calculator.calculator.service.CalculatorService;

import com.calculator.calculator.dto.Calculate.CalculateIntegerDTO;
import com.calculator.calculator.exception.BaseException;
import org.springframework.stereotype.Service;

@Service
public interface CalculatorService {
    String calculateInteger(CalculateIntegerDTO calculateIntegerDTO) throws BaseException;
}
