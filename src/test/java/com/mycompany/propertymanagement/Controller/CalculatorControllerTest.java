package com.mycompany.propertymanagement.Controller;

import com.mycompany.propertymanagement.controller.CalculatorController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CalculatorControllerTest {
    @InjectMocks
    private CalculatorController calculatorController;

    @Test
    void multiplyTest()
    {
       Double result =  calculatorController.multiply(10.0,1.0,1.0);
        Assertions.assertEquals(10,result);
    }

}
