package com.sczachariah;

import java.util.Scanner;

public class Omino {

    public static void main(String[] args) {
        int noOfCases;
        int X,R,C;
        String winner;

        Scanner scanner = new Scanner(System.in);
        noOfCases = scanner.nextInt();

        for (int i = 1; i <= noOfCases; i++) {
            winner = "RICHARD";
            X = scanner.nextInt();
            R = scanner.nextInt();
            C = scanner.nextInt();
            if(X == 1 || X >= 7)
                winner = "GABRIEL";
            else if((R*C%X==0) && (R > (X-2) && C > (X-2)))
                winner = "GABRIEL";
            System.out.println("Case #" + i + ": " + winner);
        }
    }
}
