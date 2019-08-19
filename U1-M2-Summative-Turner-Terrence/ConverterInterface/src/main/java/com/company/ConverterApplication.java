package com.company;

public class ConverterApplication {

    public static void main(String[] args) {

        ConverterIf converterIf = new ConverterIf();
        ConverterSwitch converterSwitch = new ConverterSwitch();


        converterIf.convertMonth(0);
        converterIf.convertDay(6);


        converterSwitch.convertMonth(4);
        converterSwitch.convertDay(8);

    }
}
