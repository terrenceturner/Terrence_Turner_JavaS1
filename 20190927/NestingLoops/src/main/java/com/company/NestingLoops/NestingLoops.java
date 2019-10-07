package com.company.NestingLoops;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NestingLoops {

    public static void main( String[] args ) {
        // this is #1 - I'll call it "CN"
        for ( char c='A'; c <= 'E'; c++ ) {
            for ( int n=1; n <= 3; n++ ) {
                System.out.println( c + " " + n );
            }
        }
//        for ( int n=1; n <= 3; n++ ){
//            for ( char c='A'; c <= 'E'; c++ ){
//                System.out.println( c + " " + n );
//            }
//        }

        System.out.println("\n");

        // this is #2 - I'll call it "AB"
        for ( int a=1; a <= 3; a++ ) {
            for ( int b=1; b <= 3; b++ ) {
                System.out.print( a + "-" + b + " " );
//                System.out.println(a + "-" + b + " ");
            }
            // * You will add a line of code here.
//            System.out.println(a + "-" + b + " ");
        }

        System.out.println("\n");

        Rectangle rectangle = new Rectangle();
        Square square = new Square();
        Triangle triangle = new Triangle();

        List<Shape> shapes = new ArrayList<>();
        shapes.add(rectangle);
        shapes.add(triangle);
        shapes.add(square);

        shapes.stream().forEach(shape -> {(shape).getArea();});
    }
}
