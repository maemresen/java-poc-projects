package com.maemresen.hobbyprojcts;

import java.util.Scanner;

public class Pascal {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int a = scan.nextInt();
        int sayac = a + 1;

        for (int k = 0; k < sayac - 1; k++) {
            String[] pascal = new String[a];

            for (int j = 0; j < a - 1; j++) {
                pascal[j] = " ";

            }
            pascal[a - 1] = "1";
            for (int i = 0; i < a; i++) {
                System.out.print(pascal[i]);

            }
            System.out.print("\n");
            a--;
        }


    }
}
