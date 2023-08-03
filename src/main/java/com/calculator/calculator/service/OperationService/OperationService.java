package com.calculator.calculator.service.OperationService;

import com.calculator.calculator.dto.Operation.OperationDTO;
import com.calculator.calculator.enums.Operation;
import com.calculator.calculator.exception.InvalidOperationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OperationService {

    <T> Object add(List<T> variables);

    <T> Object sub(List<T> variables);

    <T> Object mul(List<T> variables);

    <T> Object div(List<T> variables);

    default OperationDTO getOperation(String operationString){
        OperationDTO operationDTO = new OperationDTO();
        try{
            for(Operation operation : Operation.values()){
                if(operation.isOperation(operationString)){
                    operationDTO.setOperation(operation.checkOperation(operationString));
                    operationDTO.setValid(operation.isOperation(operationString));
                }
            }
        }catch (InvalidOperationException e){
            operationDTO.setOperation("Invalid");
            operationDTO.setValid(false);
        }
        return operationDTO;
    }
}
