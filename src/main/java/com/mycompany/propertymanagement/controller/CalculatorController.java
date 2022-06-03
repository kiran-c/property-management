package com.mycompany.propertymanagement.controller;

import com.mycompany.propertymanagement.dto.CalculatorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CalculatorController {

    @GetMapping("/mul")
    public Double multiply(@RequestParam("num1") Double num1 , @RequestParam("num2") Double num2)
    {
        return num1 * num2;
    }

    @GetMapping("/sub/{num1}/{num2}")
    public Double substract(@PathVariable("num1") Double num1, @PathVariable("num2") Double num2)
    {
        if(num1 > num2)
            return num1 - num2;
        else
            return num2 - num1;
    }




    @PostMapping("/add")
    public ResponseEntity addition(@RequestBody CalculatorDTO calculatorDTO)
    {
        Double result = calculatorDTO.getNum1() + calculatorDTO.getNum2() + calculatorDTO.getNum3();

        ResponseEntity<Double> responseEntity = new ResponseEntity<>(result, HttpStatus.CREATED);

        return responseEntity;
    }
}
