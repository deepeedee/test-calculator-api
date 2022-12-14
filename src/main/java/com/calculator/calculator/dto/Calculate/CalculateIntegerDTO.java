package com.calculator.calculator.dto.Calculate;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
@RequiredArgsConstructor
public class CalculateIntegerDTO extends CalculateBaseDTO{

    private List<Integer> integers;

}