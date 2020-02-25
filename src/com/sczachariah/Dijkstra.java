package com.sczachariah;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Dijkstra {

    static FileInputStream fstream;
    static BufferedReader br = null;
    static String strLine;
    static String caseLine;
    static int noOfCases = 0;
    static int L;
    static int X;
    static int C;
    static String line [];
    static String input;
    static String numInput;
    static String output="";
    static String [][] table = new String [][]{{"1","i","j","k"},
            {"i","-1","k","-j"},
            {"j","-k","-1","i"},
            {"k","j","-i","-1"}};
    static String product;
    static String oldProduct;
    static int negative;
    static int [][]pos;
    static int ipos = 0;
    static int jpos = 0;
    static int kpos = 0;
    static int p = 0;


    private static int getPos(int startpos, String letter, int letterNum, int letterpos){
        oldProduct = "";
        product = "";
        int newletterpos = letterpos;
        negative = 0;
        boolean already = false;
        for (int k = startpos; k < numInput.length(); k++) {
            if (oldProduct.length() > 0) {
                if (oldProduct.length() > 1) {
                    product = table[Character.getNumericValue(oldProduct.charAt(1))][Character.getNumericValue(numInput.charAt(k))];
                } else
                    product = table[Character.getNumericValue(oldProduct.charAt(0))][Character.getNumericValue(numInput.charAt(k))];
            } else {
                if(k < (numInput.length()-1)) {
                    product = table[Character.getNumericValue(numInput.charAt(k))][Character.getNumericValue(numInput.charAt(k + 1))];
                    k++;
                }
            }
            if (product.length() > 1) {
                negative++;
                product = product.charAt(1) + "";
                oldProduct = product.replace('1','0').replace('i','1').replace('j','2').replace('k','3');
            }
            else{
                oldProduct = product.replace('1', '0').replace('i','1').replace('j','2').replace('k','3');
            }

            if (product.equals(letter) && negative % 2 == 0) {
                negative = 0;
                for(int c=0;c<numInput.length();c++) {
                    if (pos[letterNum][c] == k) {
                        already = true;
                        break;
                    }
                    else
                        already = false;
                }

                if(!already) {
                    pos[letterNum][newletterpos] = k;
                    newletterpos++;
                }
            }
        }
        return newletterpos;
    }

    public static void main(String[] args) {



        try {
            fstream = new FileInputStream(args[0]);
            br = new BufferedReader(new InputStreamReader(fstream));

            strLine = br.readLine();
            noOfCases = Integer.parseInt(strLine);

            for (int i = 1; i <= noOfCases; i++) {
                input = "";
                output = "";

                negative = 0;
                ipos = 0;
                jpos = 0;
                kpos = 0;
                output = "NO";
                caseLine = br.readLine();
                line = caseLine.split(" ");
                L = Integer.parseInt(line[0]);
                X = Integer.parseInt(line[1]);

                caseLine = br.readLine();
                for (int j=0; j < X ; j++)
                    input = input + caseLine;

                if(!input.equals("ijk") || input.length() < 3) {
                    output = "NO";
                }
                if(input.equals("ijk"))
                    output = "YES";

                numInput = input;
                numInput = numInput.replace('i','1').replace('j','2').replace('k','3');

                pos = new int [numInput.length()][numInput.length()];

                if(numInput.length() >= 3 && output.equals("NO")) {
                    ipos = getPos(0,"i",0,ipos);

                    for(p = 0;p<ipos;p++)
                        jpos = getPos((pos[0][p])+1,"j",1,jpos);

                    for(p = 0;p<jpos;p++)
                        kpos = getPos((pos[1][p])+1,"k",2,kpos);

                    for(p=0;p<numInput.length();p++) {
                        if (pos[2][p] == numInput.length()-1)
                            output = "YES";
                    }
                }

                System.out.println("Case #" + i + ": " + output);
            }
        }
        catch (Exception e)
        {
            System.out.println("Exception Occurred" + e);

        }
        finally
        {
            try {
                br.close();
            }
            catch(Exception e) {
                System.out.println("Exception Occurred" + e);
            }
        }
    }
}
