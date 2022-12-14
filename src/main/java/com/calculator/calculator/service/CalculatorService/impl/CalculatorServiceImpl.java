package com.calculator.calculator.service.CalculatorService.impl;

import com.calculator.calculator.dto.Calculate.CalculateIntegerDTO;
import com.calculator.calculator.enums.Operation;
import com.calculator.calculator.exception.BaseException;
import com.calculator.calculator.service.CalculatorService.CalculatorService;
import com.calculator.calculator.service.OperationService.OperationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CalculatorServiceImpl implements CalculatorService {

    @Autowired
    private OperationService operationService;

    @Override
    public String calculateInteger(CalculateIntegerDTO calculateIntegerDTO) throws BaseException {
        int result = 0;
        String operation = operationService.getIntegerOperation(calculateIntegerDTO.getOperation()).getOperation();
        try {
            if(calculateIntegerDTO.getOperation()!=null){
                switch (operation)
                {
                    case "Addition": result = operationService.addInt(calculateIntegerDTO.getIntegers());
                        break;
                    case "Subtraction": result = operationService.subInt(calculateIntegerDTO.getIntegers());
                        break;
                    case "Multiplication": result = operationService.mulInt(calculateIntegerDTO.getIntegers());
                        break;
                }

            }else {
                throw new BaseException(HttpStatus.BAD_REQUEST,"400");
            }
        }catch (BaseException e){
            log.error("Error in calculator : {}",e.getMessage(),e);
            throw new BaseException(e.getHttpStatus(),e.getErrorCode());
        }
        return String.valueOf(result);
    }
}
