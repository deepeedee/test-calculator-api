package com.calculator.calculator.service.OperationService;

import com.calculator.calculator.dto.Operation.OperationDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OperationService {

    Integer addInt(List<Integer> integers);

    Integer subInt(List<Integer> integers);

    Integer mulInt(List<Integer> integers);

    OperationDTO getIntegerOperation(String operationString);
}
