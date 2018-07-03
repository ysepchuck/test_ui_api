package com.app;

public class Test {

    public static void main (String[] args){

        double age = 99;
        if (age <= 0){
            System.out.println("Error");
        }
        else if (age <= 16 ){
            System.out.println("Too young");
        }
        else if (age <= 100) {
            System.out.println("Welcome");
        }
        else {
            System.out.println("Really");
        }

    }


}
