package com.calculator.calculator.service.CalculatorService.impl;

import com.calculator.calculator.dto.Calculate.CalculateIntegerDTO;
import com.calculator.calculator.dto.Calculate.CalculateLongDTO;
import com.calculator.calculator.exception.BaseException;
import com.calculator.calculator.service.CalculatorService.CalculatorService;
import com.calculator.calculator.service.OperationService.OperationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Component
public class CalculatorServiceImpl implements CalculatorService {

    @Autowired
    @Resource(name = "integerService")
    private OperationService integerService;

    @Autowired
    @Resource(name = "doubleService")
    private OperationService doubleService;

    @Override
    public String calculateInteger(CalculateIntegerDTO calculateIntegerDTO) throws BaseException {
        int result = 0;
        String operation = integerService.getOperation(calculateIntegerDTO.getOperation()).getOperation();
        try {
            if(calculateIntegerDTO.getOperation()!=null){
                switch (operation)
                {
                    case "Addition": result = (int) integerService.add(calculateIntegerDTO.getIntegers());
                        break;
                    case "Subtraction": result = (int) integerService.sub(calculateIntegerDTO.getIntegers());
                        break;
                    case "Multiplication": result = (int) integerService.mul(calculateIntegerDTO.getIntegers());
                        break;
                    case  "Division" : result = (int) doubleService.div(calculateIntegerDTO.getIntegers());
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

    @Override
    public String calculateDouble(CalculateLongDTO calculateLongDTO) throws BaseException {
        double result = 0;
        String operation = doubleService.getOperation(calculateLongDTO.getOperation()).getOperation();
        try {
            if(calculateLongDTO.getOperation()!=null){
                switch (operation)
                {
                    case "Addition": result = (double) doubleService.add(calculateLongDTO.getIntegers());
                        break;
                    case "Subtraction": result = (double) doubleService.sub(calculateLongDTO.getIntegers());
                        break;
                    case "Multiplication": result = (double) doubleService.mul(calculateLongDTO.getIntegers());
                        break;
                    case  "Division" : result = (double) doubleService.div(calculateLongDTO.getIntegers());
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
