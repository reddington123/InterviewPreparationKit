/*
Title     : Repeated String
Subdomain : Warm-up Challenges
Domain    : Interview Preparation Kit
Author    : Sachin Kumar Tiwari
Problem   : https://www.hackerrank.com/challenges/repeated-string/problem
*/
package Warmup;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;

import java.util.concurrent.*;
import java.util.regex.*;
public class RepeatedString {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        long str_len = s.length();
        long num_times = n/str_len;
        long rem = n%str_len;
        long num=0,res=0;
        for(int i=0;i<str_len;i++){
            if(s.charAt(i)=='a'){
                num++;
            }
        }
        res = num*num_times;
        num=0;
        for(int i=0;i<rem;i++){
            if(s.charAt(i)=='a'){
                num++;
            }
        }
        res = res+num;
        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        /* For Hackerrank use this */
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        /* For IntelliJ use this */
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}