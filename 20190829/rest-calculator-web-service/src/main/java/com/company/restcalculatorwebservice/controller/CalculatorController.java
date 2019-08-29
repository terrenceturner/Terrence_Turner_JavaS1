package com.company.restcalculatorwebservice.controller;

import com.company.restcalculatorwebservice.model.Calculator;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Random;

@RestController
public class CalculatorController {

    @RequestMapping(value = "/add", method = RequestMethod.POST)

    @ResponseStatus(value = HttpStatus.CREATED)

    public Calculator addCalculator(@RequestBody @Valid Calculator calculator){
        Random random = new Random();
        calculator.setOperand1(random.nextInt(9999));
        calculator.setOperand2(random.nextInt(9999));

        return calculator;
    }

    @RequestMapping(value = "/subtract", method = RequestMethod.POST)

    @ResponseStatus(value = HttpStatus.CREATED)

    public Calculator subtractCalculator(@RequestBody @Valid Calculator calculator){
        Random random = new Random();
        calculator.setOperand1(random.nextInt(9999));
        calculator.setOperand2(random.nextInt(9999));

        return calculator;
    }

    @RequestMapping(value = "/mult", method = RequestMethod.POST)

    @ResponseStatus(value = HttpStatus.CREATED)

    public Calculator multCalculator(@RequestBody @Valid Calculator calculator){
        Random random = new Random();
        calculator.setOperand1(random.nextInt(9999));
        calculator.setOperand2(random.nextInt(9999));

        return calculator;
    }

    @RequestMapping(value = "/divide", method = RequestMethod.POST)

    @ResponseStatus(value = HttpStatus.CREATED)

    public Calculator divideCalculator(@RequestBody @Valid Calculator calculator){
        Random random = new Random();
        calculator.setOperand1(random.nextInt(9999));
        calculator.setOperand2(random.nextInt(9999));

        return calculator;
    }
}
