package com.app;

import com.app.Square;

public class Main {
    public static void main(String[] args) {
        hello("World");

        Square s = new Square(5);

        System.out.println(" площядь квадрата " + s.l + " = " + s.area ());
    }

    public static void hello(String somebody) {
        System.out.println( "Hello " + somebody + "!");

    }

}
