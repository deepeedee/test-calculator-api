package com.calculator.calculator.service.OperationService.impl;

import com.calculator.calculator.dto.Operation.OperationDTO;
import com.calculator.calculator.service.OperationService.OperationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class DoubleService implements OperationService {

    @Override
    public <T> Double add(List<T> variables){
        double tempInt = 0;
        List<Double> doubleList = variables.stream().map(var->(double)var).collect(Collectors.toList());
        for (Double i : doubleList) {
            tempInt += i;
        }
        return tempInt;
    }

    @Override
    public <T> Double sub(List<T> variables){
        List<Double> doubleList = variables.stream().map(var->(double)var).collect(Collectors.toList());
        double tempInt = doubleList.get(0);
        for (int i = 1; i<doubleList.size(); i++) {
            tempInt -= doubleList.get(i);
        }
        return tempInt;
    }

    @Override
    public <T> Double mul(List<T> variables){
        List<Double> doubleList = variables.stream().map(var->(double)var).collect(Collectors.toList());
        double tempInt = doubleList.get(0);
        for (int i = 1; i<doubleList.size(); i++) {
            tempInt *= doubleList.get(i);
        }
        return tempInt;
    }

    @Override
    public <T> Double div(List<T> variables){
        List<Double> doubleList = variables.stream().map(var->(double)var).collect(Collectors.toList());
        double tempInt = doubleList.get(0);
        for (int i = 1; i<doubleList.size(); i++) {
            tempInt /= doubleList.get(i);
        }
        return tempInt;
    }
}
