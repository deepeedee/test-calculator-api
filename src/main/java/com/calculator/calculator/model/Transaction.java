package com.calculator.calculator.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import javax.persistence.*;

@Slf4j
@Data
@NoArgsConstructor
@Entity(name = "Transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer id;

    @Column(name="OPERATION")
    private String operation;

    @Column(name = "DETAILS", columnDefinition = "json")
    private String details;

    @Column(name = "RESULT")
    private String result;
}
