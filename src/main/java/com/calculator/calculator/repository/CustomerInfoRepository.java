package com.calculator.calculator.repository;

import com.calculator.calculator.model.CustomerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerInfoRepository extends JpaRepository<CustomerInfo,Integer> {
    
}
