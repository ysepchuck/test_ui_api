package com.app;

public class Euqation {

    private double a;
    private double b;
    private double c;

    private int p;

    public Euqation(double a, double b, double c){

        this.a = a;
        this.b = b;
        this.c = c;

        double d = b * b - 4 * a * c;

        if (d > 0) {
            p = 2;
        } else {
            if (d == 0) {
                p = 1;
            } else {
                p = 0;
            }
        }

    }

    public int rootNumber () {
        return p;
    }

}
