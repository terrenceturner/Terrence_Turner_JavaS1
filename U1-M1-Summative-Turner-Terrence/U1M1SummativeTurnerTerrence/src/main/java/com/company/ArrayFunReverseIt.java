package com.company;

public class ArrayFunReverseIt {

    public static void main(String[] args) {

        int[] simpleArray = {1, 2, 3, 4, 5};

        int[] otherArray = new int[simpleArray.length];
        int k = 0;

        for (int i = simpleArray.length - 1; i > -1; i--){
            otherArray[k] = simpleArray[i];
            k++;

        }

        System.out.println("otherArray: ");

        for (int element:otherArray) {
            System.out.println(element);
        }

        System.out.println("simpleArray: ");

        for (int element:simpleArray) {
            System.out.println(element);
        }



    }
}
