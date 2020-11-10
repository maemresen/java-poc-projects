package com.maemresen.hobbyprojcts;

import java.util.Scanner;

public class CliEquationSolver {

    public static class SimpleEquation {
        double b;
        double a;
        double resse;

        public SimpleEquation(double x, double y) {
            a = x;
            b = y;
        }

        public void printSimpleEquation() {
            System.out.print("(" + a + ")" + "x" + "+" + "(" + b + ")" + "=" + "0" + "\n");

        }

        public void SolveSimpleEquation(double constant, double parameter) {
            resse = (-constant) / parameter;
            System.out.print("Your result is:" + resse + "\n");
            return;
        }
    }


    public static class QuadraticEquation {
        double a, b, c, x1, x2, delta, resqe1, resqe2;

        public QuadraticEquation(double d, double e, double f) {
            a = d;
            b = e;
            c = f;
        }

        public void printQuadraticEquation() {
            System.out.print("(" + a + ")" + "x²" + "(" + b + ")" + "x" + "+" + c + "\n");
        }

        public void SolveQuadraticEquation(double a, double b, double c) {
            delta = (b * b) - 4 * (a * c);
            if (delta < 0) {
                System.out.print("Your delta is smaller than 0 so you have no roots" + "\n");
            } else if (delta >= 0) {
                System.out.print("Your delta is equal 0 so you have two same root" + "\n");
                resqe1 = ((-b) + Math.sqrt(delta)) / (2 * a);
                resqe2 = ((-b) - Math.sqrt(delta)) / (2 * a);
                System.out.print("Your first root is:" + resqe1 + "\n");
                System.out.print("Your second root is:" + resqe2 + "\n");
                return;
            }
        }
    }


    static double parameter, constant, a, b, c, resse, resqe;
    static int i;
    static String doe, cep;
    private static Scanner scani;
    private static SimpleEquation se;
    private static Scanner scans;
    private static QuadraticEquation qe;

    public static void print(String c) {
        System.out.print(c);
    }

    public static void main(String[] args) {
        scani = new Scanner(System.in);
        scans = new Scanner(System.in);
        do {
            do {    // choose valid degree
                print("Enter 1 for solve simple equation" + "\n");
                print("Enter 2 for solve quadratic equation" + "\n");
                print("=>");
                doe = scans.nextLine();
                switch (doe) {
                    case "1":
                        print("Enter parameter of x:");
                        parameter = scani.nextDouble();
                        print("Enter constant:");
                        constant = scani.nextDouble();
                        se = new SimpleEquation(parameter, constant);
                        se.printSimpleEquation();
                        se.SolveSimpleEquation(constant, parameter);
                        i = 2;
                        break;
                    case "2":
                        print("like that" + "\n" + "ax²+bx+c" + "\n");
                        print("Enter a:");
                        a = scani.nextDouble();
                        print("Enter b:");
                        b = scani.nextDouble();
                        print("Enter c:");
                        c = scani.nextDouble();
                        qe = new QuadraticEquation(a, b, c);
                        qe.SolveQuadraticEquation(a, b, c);
                        i = 2;
                        break;
                    default:
                        print("Enter a valid number!!" + "\n");
                        i = 0;
                }//choose degree of equation(switch)
            } while (i < 1);//Choose valid degree
            do {
                print("Enter 1 for change degree of equation and parameters" + "\n");
                print("Enter 2 for finish program" + "\n" + "=>");
                cep = scans.nextLine();
                switch (cep) {
                    case "1":
                        i = 2;
                        break;
                    case "2":
                        i = 4;
                        break;
                    default:
                        print("Enter a valid number:" + "\n");
                        i = 0;
                }
            } while (i < 1);
        } while (i < 3);//change degree of equation
        print("Thanks for try my program!!");
    }//main
}//class
