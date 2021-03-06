/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hue2.bsp4;

import java.util.Scanner;

/**
 *
 * @author holzm
 */
//4.Beispiel
public class Main2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in, "Windows-1252");

        RationalCalculator rc = new RationalCalculator((a, b) -> {
            double zaehler = a.getA() * b.getB() + b.getA() * a.getB();
            double nenner = a.getB() * b.getB();
            Number number = new Number();
            number.setA(zaehler);
            number.setB(nenner);
            return number;
        }, (a, b) -> {
            double zaehler = a.getA() * b.getB() - b.getA() * b.getB();
            double nenner = a.getB() * b.getA() + b.getB() * a.getA();
            Number number = new Number();
            number.setA(zaehler);
            number.setB(nenner);
            return number;
        }, (a, b) -> {
            double zaehler = a.getA() * b.getA();
            double nenner = a.getB() * b.getB();
            Number number = new Number();
            number.setA(zaehler);
            number.setB(nenner);
            return number;
        }, (a, b) -> {
            double zaehler = a.getA() * b.getB();
            double nenner = a.getB() * b.getA();
            Number number = new Number();
            number.setA(zaehler);
            number.setB(nenner);
            return number;
        });

        VectorCalculator vc = new VectorCalculator((a, b) -> {
            double x = a.getA() + b.getA();
            double y = b.getB() + b.getB();
            Number number = new Number();
            number.setA(x);
            number.setB(y);
            return number;
        }, (a, b) -> {
            double x = a.getA() - b.getA();
            double y = a.getB() - b.getB();
            Number number = new Number();
            number.setA(x);
            number.setB(y);
            return number;
        }, (a, b) -> {
            double zaehler = a.getA() * b.getB() + a.getB() * b.getA();
            Number number = new Number();
            number.setA(zaehler);
            number.setB(1);
            return number;
        }, (a, b) -> {
            double zaehler = a.getA() * b.getA() + a.getB() + b.getB();
            Number number = new Number();
            number.setA(zaehler);
            number.setB(1);
            return number;
        });

        ComplexCalculator cc = new ComplexCalculator((a, b) -> {
            double x = a.getA() + b.getB();
            double y = a.getB() + b.getB();
            Number number = new Number();
            number.setA(x);
            number.setB(y);
            return number;
        }, (a, b) -> {
            double x = a.getA() - b.getB();
            double y = a.getB() - b.getB();
            Number number = new Number();
            number.setA(x);
            number.setB(y);
            return number;
        }, (a, b) -> {
            double x = a.getA() * b.getA() - a.getB() * b.getB();
            double y = a.getA() * b.getA() + a.getB() * b.getB();
            Number number = new Number();
            number.setA(x);
            number.setB(y);
            return number;
        }, (a, b) -> {
            double x = a.getA() + a.getB();
            double y = b.getA() + b.getB();
            Number number = new Number();
            number.setA(x);
            number.setB(y);
            return number;
        });

        menu();
        int ausw = Integer.parseInt(scanner.nextLine());

        while (ausw < 4) {

            System.out.print("Nummer eigeben x a: \n");
            int xa = Integer.parseInt(scanner.nextLine());
            System.out.print("Nummer eingeben x b: \n");
            int xb = Integer.parseInt(scanner.nextLine());
            System.out.print("Nummer eingeben y a: \n");
            int ya = Integer.parseInt(scanner.nextLine());
            System.out.print("Nummer eingeben y b: \n");
            int yb = Integer.parseInt(scanner.nextLine());

            System.out.println("Choose operation:");
            System.out.println("1.. add");
            System.out.println("2.. subtract");
            System.out.println("3.. multiply");
            System.out.println("4.. divide");
            ;
            int operation = Integer.parseInt(scanner.nextLine());
            Number number1 = new Number();
            number1.setA(xa);
            number1.setB(xb);
            Number number2 = new Number();
            number2.setA(ya);
            number2.setB(yb);
            Number erg = new Number();
            switch (ausw) {
                case 1:
                    switch (operation) {
                        case 1:

                            erg = rc.add(number1, number2);
                            break;
                        case 2:

                            erg = rc.subtract(number1, number2);
                            break;
                        case 3:

                            erg = rc.multiply(number1, number2);
                            break;
                        case 4:

                            erg = rc.divide(number1, number2);
                            break;
                    }
                    break;

                case 2:

                    switch (operation) {
                        case 1:

                            erg = vc.add(number1, number2);
                            break;
                        case 2:

                            erg = vc.subtract(number1, number2);
                            break;
                        case 3:

                            erg = vc.multiply(number1, number2);
                            break;
                        case 4:

                            erg = vc.divide(number1, number2);
                            break;
                        default:

                            break;
                    }
                    ;
                    break;
                case 3:
                    switch (operation) {
                        case 1:

                            erg = cc.add(number1, number2);
                            break;
                        case 2:

                            erg = cc.subtract(number1, number2);
                            break;
                        case 3:

                            erg = cc.multiply(number1, number2);
                            break;
                        case 4:

                            erg = cc.divide(number1, number2);
                            break;
                        default:

                            break;
                    }
                    ;
                    break;
                case 4:
                    System.exit(0);
            }

            System.out.println("Solution:");
            System.out.println("a : " + erg.getA());
            System.out.println("b : " + erg.getB());
            menu();
            ausw = Integer.parseInt(scanner.nextLine());
        }
        System.exit(0);

    }

    private static void menu() {
        System.out.println("Choose calculator:");
        System.out.println("1 - Rational calculator");
        System.out.println("2 - Vector calculator");
        System.out.println("3 - Complex calculator");
        System.out.println("4 - Exit");
    }

}
