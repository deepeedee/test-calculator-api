package com.calculator.calculator.service.OperationService.impl;

import com.calculator.calculator.dto.Operation.OperationDTO;
import com.calculator.calculator.enums.Operation;
import com.calculator.calculator.exception.InvalidOperationException;
import com.calculator.calculator.service.OperationService.OperationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
@Slf4j
@Component
public class OperationServiceImpl implements OperationService {

    @Override
    public Integer addInt(List<Integer> integers){
        int tempInt = 0;
        for (Integer i : integers) {
            tempInt += i;
        }
        return tempInt;
    }

    @Override
    public Integer subInt(List<Integer> integers){
        int tempInt = integers.get(0);
        for (int i = 1; i<integers.size(); i++) {
            tempInt -= integers.get(i);
        }
        return tempInt;
    }

    @Override
    public Integer mulInt(List<Integer> integers){
        int tempInt = integers.get(0);
        for (int i = 1; i<integers.size(); i++) {
            tempInt *= integers.get(i);
        }
        return tempInt;
    }

    

    @Override
    public OperationDTO getIntegerOperation(String operationString){

        OperationDTO operationDTO = new OperationDTO();
        try{
            for(Operation operation : Operation.values()){
                if(operation.isOperation(operationString)){
                    operationDTO.setOperation(operation.checkOperation(operationString));
                    operationDTO.setValid(operation.isOperation(operationString));
                }
            }
        }catch (InvalidOperationException e){
            log.error("Invalid Operations");
            operationDTO.setOperation("Invalid");
            operationDTO.setValid(false);
        }
        return operationDTO;
    }
}
