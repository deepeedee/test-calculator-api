package com.calculator.calculator.service.CarwashService;

import com.calculator.calculator.dto.Carwash.CarwashRegisterDTO;
import com.calculator.calculator.model.CustomerInfo;
import com.calculator.calculator.repository.CustomerInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CarwashService {

    @Autowired
    private CustomerInfoRepository customerInfoRepository;

    public CustomerInfo register(CarwashRegisterDTO carwashRegisterDTO){
        CustomerInfo customerInfo = new CustomerInfo(carwashRegisterDTO);
        return  customerInfoRepository.saveAndFlush(customerInfo);
    }
}
