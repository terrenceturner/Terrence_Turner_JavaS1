package com.company;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PhoneReader {

    public static void main(String[] args) {

        try {


            ObjectMapper mapper = new XmlMapper();

            List<Phones> phones = mapper.readValue(new File("/Users/terrenceturner/Desktop/Terrence_Turner_JavaS1/20190821/04-lesson-structured-data-files/activities/katas/starter-code/U1M3L4Katas/phones.xml"),
                    new TypeReference<List<Televisions>>(){});


            for (Phones phone : phones) {
                System.out.println("===============");
                System.out.println(phone.getBrand());
                System.out.println(phone.getModel());
                System.out.println(phone.getPrice());
                System.out.println(phone.getProcessor());
                System.out.println(phone.getStorage());

            }

        } catch (IOException e) {
            System.out.println("ERROR: Could not write to file: " + e.getMessage());
        }

    }




}
