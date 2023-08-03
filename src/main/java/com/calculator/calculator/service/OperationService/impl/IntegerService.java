package com.calculator.calculator.service.OperationService.impl;

import com.calculator.calculator.service.OperationService.OperationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class IntegerService implements OperationService {

    @Override
    public <T> Integer add(List<T> variables){
        int tempInt = 0;
        List<Integer> integerList = variables.stream().map(var->(int)var).collect(Collectors.toList());
        for (Integer i : integerList) {
            tempInt += i;
        }
        return tempInt;
    }

    @Override
    public <T> Integer sub(List<T> variables){
        List<Integer> integerList = variables.stream().map(var->(int)var).collect(Collectors.toList());
        int tempInt = integerList.get(0);
        for (int i = 1; i<integerList.size(); i++) {
            tempInt -= integerList.get(i);
        }
        return tempInt;
    }

    @Override
    public <T> Integer mul(List<T> variables){
        List<Integer> integerList = variables.stream().map(var->(int)var).collect(Collectors.toList());
        int tempInt = integerList.get(0);
        for (int i = 1; i<integerList.size(); i++) {
            tempInt *= integerList.get(i);
        }
        return tempInt;
    }

    @Override
    public <T> Integer div(List<T> variables){
        List<Integer> integerList = variables.stream().map(var->(int)var).collect(Collectors.toList());
        int tempInt = integerList.get(0);
        for (int i = 1; i<integerList.size(); i++) {
            tempInt /= integerList.get(i);
        }
        return tempInt;
    }
}
