package com.calculator.calculator.controller;

import com.calculator.calculator.dto.Calculate.CalculateIntegerDTO;
import com.calculator.calculator.dto.Carwash.CarwashRegisterDTO;
import com.calculator.calculator.exception.BaseException;
import com.calculator.calculator.model.CustomerInfo;
import com.calculator.calculator.service.CarwashService.CarwashService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/carwash")
public class CarwashController {

    @Autowired
    private CarwashService carwashService;

    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerInfo> register(@RequestBody CarwashRegisterDTO carwashRegisterDTO){
        log.info("Register Process:{}",carwashRegisterDTO);
        ResponseEntity<CustomerInfo> response;
        response = ResponseEntity.ok(carwashService.register(carwashRegisterDTO));
        return response;
    }
}
