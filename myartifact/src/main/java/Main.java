import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        hello("World");


        double l = 6;
        System.out.println(" площядь квадрата " + l + " = " + area (l));
    }

    public static void hello(String somebody) {
        System.out.println( "Hello " + somebody + "!");

    }
    public static double area (double len) {
        return len * len;
    }

}
