package com.mycompany.propertymanagement.Controller;

import com.mycompany.propertymanagement.controller.CalculatorController;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CalculatorControllerTest {
    @InjectMocks
    private CalculatorController calculatorController;

    static Double  num1;
    static Double  num2;
    static Double  num3;


    @BeforeAll
    static void beforeAll()
    {
        num1 = 10.0;
        num2 = 1.0;
        num3 = 1.0;
        System.out.println("Before All");
    }


    @AfterAll
    static void afterAll()
    {
        num1 = null;
        num2 = null;
        num3 = null;
        System.out.println("After All");
    }

    @BeforeEach
    void init()
    {
         /*num1 = 10.0;
         num2 = 1.0;
         num3 = 1.0;*/

        System.out.println("Before Each....!");
    }

   @AfterEach
    void destroy()
    {
        /*num1 = null;
        num2 = null;
        num3 = null;
*/        System.out.println("After Each....!");
    }

    @Test
    @DisplayName("EqualityTest")
    @Disabled
    void multiplyTestSuccess()
    {
       Double result =  calculatorController.multiply(num1, num2, num3);
       System.out.println("Test case Success Scenario");
       Assertions.assertEquals(10,result);
    }

    @Test
    @DisplayName("UnequalityTest")
    @Disabled
    void multiplyTestFailure()
    {
        Double result =  calculatorController.multiply(num1, num2, num3);
        System.out.println("Test case Failure Scenario");
        Assertions.assertNotEquals(5,result);
    }

    @Test
    @DisplayName("SubstractTest")
    void substractTestSuccess_num1_gt_num2()
    {
        Double result =  calculatorController.substract(num1 + 2, num2);
        System.out.println("Test case substarct Success Scenario");
        Assertions.assertEquals(11,result);
    }

    @Test
    @DisplayName("SubstractTest")
    void substractTestSuccess_num2_gt_num1()
    {
        Double result =  calculatorController.substract(num1, num2+2);
        System.out.println("Test case substarct Success Scenario");
        Assertions.assertEquals(7,result);
    }


}
