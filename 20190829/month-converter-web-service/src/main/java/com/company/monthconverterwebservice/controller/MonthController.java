package com.company.monthconverterwebservice.controller;

import com.company.monthconverterwebservice.model.Month;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class MonthController {

    @RequestMapping(value = "/month/{monthNumber}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)

    public Month getMonth(@PathVariable int monthNumber) {

        if (monthNumber < 1 || monthNumber > 12) {
            throw new IllegalArgumentException("Input must be between 1 and 12.");
        }

        Month months = new Month();
        switch (monthNumber){
            case 1:
                months.setJanuary("January");
                break;
            case 2:
                months.setFebrurary("February");
                break;
            case 3:
                months.setJanuary("March");
                break;
            case 4:
                months.setFebrurary("April");
                break;
            case 5:
                months.setJanuary("May");
                break;
            case 6:
                months.setFebrurary("June");
                break;
            case 7:
                months.setJanuary("July");
                break;
            case 8:
                months.setFebrurary("August");
                break;
            case 9:
                months.setJanuary("September");
                break;
            case 10:
                months.setFebrurary("October");
                break;
            case 11:
                months.setJanuary("November");
                break;
            case 12:
                months.setFebrurary("December");
                break;
            default:

        }

        return months;
    }
}
