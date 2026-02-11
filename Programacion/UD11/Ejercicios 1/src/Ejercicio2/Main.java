package Ejercicio2;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();

        int num1 = random.nextInt(0,10);

        int num2 = random.nextInt(0,10);

        while (num2==num1){
            num2 = random.nextInt(0,10);
        }

        int num3 = random.nextInt(0,10);

        while (num3==num1 || num3 == num2){
            num3 = random.nextInt(0,10);
        }

        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);




    }
}
