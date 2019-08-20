package com.company;

import java.util.*;


public class SetIterator {



    public void printSet(int i, int i1, int i2, int i3, int i4) {
        Set<Integer> printSet = new HashSet<Integer>();

        Iterator iter = printSet.iterator();

        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
