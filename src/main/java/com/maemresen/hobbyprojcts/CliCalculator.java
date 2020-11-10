package com.maemresen.hobbyprojcts;

import java.util.Scanner;

public class CliCalculator {
    private static Scanner scani;
    private static Scanner scans;

    public static void wr(String c) {
        System.out.print(c);
    }

    public static void main(String[] args) {
        wr("Hello!!This is a calculator for some basic math operation" + "\n");
        String plsn = "Please enter a number: ";
        String plsop = "Please select operation" + "\n" + "+ for addition" + "\n" + "- for subtract" + "\n" + "* for multiply" + "\n" + "/ for dvide: ";
        String res = "Your result is: ";
        int i = 1;
        scani = new Scanner(System.in);
        scans = new Scanner(System.in);
        do { //sayıları ve işlemi değiştirme döngüsü başlangıç
            wr(plsn);
            double n1 = scani.nextDouble();
            wr(plsn);
            double n2 = scani.nextDouble();
            do { //işlemi değiştirme döngüsü başlangıç
                do { //Geçerli matematik işlemi seç döngüsü başlangıç
                    wr(plsop);
                    String op = scans.nextLine();
                    switch (op) {//matematik işlemi seç başlangıç
                        case "+":
                            double add = n1 + n2;
                            wr(res + add);
                            i = 2;
                            break;
                        case "-":
                            do { //geçerli çıkan seç döngüsü başlangıç
                                wr("Which number is first number(first or second number): ");
                                String ords = scans.nextLine();
                                switch (ords) {//eksilen ve çıkanı seç başlangıç
                                    case "first":
                                        double sub = n1 - n2;
                                        wr(res + sub);
                                        i = 2;
                                        break;
                                    case "second":
                                        double sub2 = n2 - n1;
                                        wr(res + sub2);
                                        i = 2;
                                        break;
                                    default:
                                        wr("This undifine please try again !! " + "\n");
                                        i = 0;
                                }//eksilen ve çıkanı seç bitiş
                            } while (i < 1);//geçerli çıkan seç döngüsü bitiş
                            break;
                        case "*":
                            double multi = n1 * n2;
                            wr(res + multi);
                            i = 2;
                            break;
                        case "/":
                            do { //geçerli böleni seç döngüsü başlangıç
                                wr("Which number is divisor ?(first or second number): ");
                                String ordd = scans.nextLine();
                                switch (ordd) {//bölünen ve böleni seç başlangıç
                                    case "first":
                                        double div = n1 / n2;
                                        wr(res + div);
                                        i = 2;
                                        break;
                                    case "second":
                                        double div2 = n2 / n1;
                                        wr(res + div2);
                                        i = 2;
                                        break;
                                    default:
                                        wr("This is undifine please try again !! " + "\n");
                                        i = 0;
                                }//bölünen ve böleni seç bitiş
                            } while (i < 1);//geçerli böleni seç döngüsü bitiş
                            break;
                        default:
                            wr("This operation is undifine please select another operation!!" + "\n");
                            i = 0;
                    }//matematik işlemi seç bitiş
                } while (i < 1);//Geçerli matematik işlemi seç döngüsü bitiş
                wr("\n" + "What would you like to do know ?" + "\n");
                do { //Geçerli işlem seç döngüsü başlangıç
                    wr("Press 1 for change operation " + "\n" + "press 2 for change numbers" + "\n" + "press 3 for change numbers and operation" + "\n" + "press 4 for finish program: ");
                    String sop = scans.nextLine();
                    switch (sop) {//işlem seç başlangıç
                        case "1":
                            i = 4;
                            break;
                        case "2":
                            wr("This command is invalid for now.It will be able coming soon" + "\n");
                            i = 0;
							/*i=2;
							wr(plsn);
							n1=scani.nextDouble();
							wr(plsn);
							n2  =scani.nextDouble();
							break; */
                            break;
                        case "3":
                            i = 6;
                            break;
                        case "4":
                            wr("!!Thank you for try my program!!" + "\n");
                            i = 8;
                            break;
                        default:
                            wr("This is undefine command please try again!! " + "\n");
                            i = 0;
                            break;
                    }//işlem seçme bitiş
                } while (i < 1);//Geçerli işlem seç döngüsü bitiş
            } while (i < 5); //işlemi değiştirme döngüsü bitiş
        } while (i < 7);//sayıları ve işlemi değiştirme döngüsü bitiş
    }//main
}//class