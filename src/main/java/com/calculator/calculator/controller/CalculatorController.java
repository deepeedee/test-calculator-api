package com.calculator.calculator.controller;

import com.calculator.calculator.dto.Calculate.CalculateIntegerDTO;
import com.calculator.calculator.exception.BaseException;
import com.calculator.calculator.service.CalculatorService.CalculatorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/calculate")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping(value= "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getHello(){
        return "Hello";
    }

    @PostMapping(value = "/integer", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> calculate(@RequestBody CalculateIntegerDTO calculateIntegerDTO){
        log.info("Calculate:{}",calculateIntegerDTO);
        ResponseEntity<String> response;
        try {
            response = ResponseEntity.ok(calculatorService.calculateInteger(calculateIntegerDTO));
        }catch (BaseException e){
            response = ResponseEntity.status(e.getHttpStatus()).body(e.getMessage());
        }
        return response;
    }
}
