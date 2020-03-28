/*
Title     : Counting Valleys
Subdomain : Warm-up Challenges
Domain    : Interview Preparation Kit
Author    : Sachin Kumar Tiwari
Problem   : https://www.hackerrank.com/challenges/counting-valleys/problem
*/
package Warmup;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CountingValleys {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        int nv=0;
        int step=0;
        int i = 0;
        while(i<n){
            if(s.charAt(i)=='U'){
                step=step+1;
            }else if(s.charAt(i)=='D'){
                step=step-1;
            }
            if(step==0 && s.charAt(i)=='U'){
                nv = nv +1;
            }
            //System.out.println("At i= "+i+" step = "+step+" nv = "+nv);
            i = i+1;
        }
        return nv;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        /* For Hackerrank use this */
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        /* For IntelliJ use this */
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}