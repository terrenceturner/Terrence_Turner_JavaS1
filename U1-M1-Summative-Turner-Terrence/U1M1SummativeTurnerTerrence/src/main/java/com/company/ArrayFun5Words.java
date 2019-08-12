package com.company;

import java.util.Scanner;

public class ArrayFun5Words {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] wordsFun = new String[5];

        for (int i = 0; i < wordsFun.length; i++){
            System.out.println("Type a word: ");
            String funWords = scanner.nextLine();
            wordsFun[i] = funWords;
        }

        System.out.println("You typed in: ");

        for (String element:wordsFun) {
            System.out.println(element);
        }





    }



}


