package com.maemresen.hobbyprojcts;

import java.util.Random;
import java.util.Scanner;

public class FindPossibility {
    static int a, b, d, e, f, g, i, t, constant;
    static Scanner scani, scans;
    static Random randi, rands;

    public static void main(String[] args) {
        scani = new Scanner(System.in);
        scans = new Scanner(System.in);
        randi = new Random();
        rands = new Random();
        t = 0;
        constant = 6;
        do {
            a = randi.nextInt(6) + 1;
            b = randi.nextInt(6) + 1;
            d = randi.nextInt(6) + 1;
            e = randi.nextInt(6) + 1;
            f = randi.nextInt(6) + 1;
            g = randi.nextInt(6) + 1;
            if (a == constant) {
                if (a == b) {
                    if (a == d) {
                        if (a == e) {
                            if (a == f) {
                                if (a == g) {
                                    i = 2;
                                } else {
								/*	System.out.println(t+" times try");
									System.out.println(a);
									System.out.println(b);
									System.out.println(d);
									System.out.println(e);
									System.out.println(g);
									System.out.println(f);*/
                                }
                            } else {
							/*	System.out.println(t+" times try");
								System.out.println(a);
								System.out.println(b);
								System.out.println(d);
								System.out.println(e);
								System.out.println(g);
								System.out.println(f);*/
                            }
                        } else {
                            i = 0;
                            t++;
							/*System.out.println(t+" times try");
							System.out.println(a);
							System.out.println(b);
							System.out.println(d);
							System.out.println(e);
							System.out.println(g);
							System.out.println(f);*/
                        }
                    } else {
                        i = 0;
                        t++;
						/*System.out.println(t+" times try");
						System.out.println(t+" times try");
						System.out.println(a);
						System.out.println(b);
						System.out.println(d);
						System.out.println(e);
						System.out.println(g);
						System.out.println(f);*/
                    }
                } else {
                    i = 0;
                    t++;
					/*System.out.println(t+" times try");
					System.out.println(t+" times try");
					System.out.println(a);
					System.out.println(b);
					System.out.println(d);
					System.out.println(e);
					System.out.println(g);
					System.out.println(f);*/
                }
            } else {
                i = 0;
                t++;
            }
        } while (i < 1);
        System.out.println(t + " times try");
        System.out.println(a);
        System.out.println(b);
        System.out.println(d);
        System.out.println(e);
        System.out.println(g);
        System.out.println(f);

    }
}
