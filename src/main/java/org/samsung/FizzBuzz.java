package org.samsung;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public static String FizzBuzz(int number) {
       if(number < 0) {
           throw new IllegalArgumentException("Number must be a positive integer");
       } else {
           StringBuilder str = new StringBuilder();
           for(int i = 1; i <= number; i++) {
               if(i % 3 == 0 && i % 5 == 0) {
                   str.append(" FizzBuzz");
               } else if(i % 3 == 0) {
                   str.append(" Fizz");
               }
               else if(i % 5 == 0) {
                   str.append(" Buzz");
               }
               else {
                   str.append(" "+i);
               }
           }
           return str.toString();
       }
    }
    public static List<String> FizzBuzz2(int number) {
        if(number < 0) {
            throw new IllegalArgumentException("Number must be a positive integer");
        } else {
            List<String> list = new ArrayList<String>();
            for(int i = 1; i <= number; i++) {
                if(i % 3 == 0 && i % 5 == 0) {
                    list.add("FizzBuzz");
                } else if(i % 3 == 0) {
                    list.add("Fizz");
                }
                else if(i % 5 == 0) {
                    list.add("Buzz");
                }
                else {
                    list.add(""+i);
                }
            }
            return list;
        }
    }
}
