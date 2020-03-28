package Warmup;
/*
Title     : Jumping On the Clouds
Subdomain : Warm-up Challenges
Domain    : Interview Preparation Kit
Author    : Sachin Kumar Tiwari
Problem   : https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem
*/
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class jumping_on_the_clouds {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        int num_jumps=0;
        int i=0;
        while(i<c.length){
            if( ((i+2)<c.length) && c[i+2]==0){
                i=i+2;
                num_jumps+=1;
            }else if( ((i+1)<c.length) && c[i+1]==0){
                i=i+1;
                num_jumps+=1;
            }else{
                i=i+1;
            }
            //System.out.println("At i = "+i+" num_jumps = "+num_jumps);
        }
        return num_jumps;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        /* For Hackerrank use this */
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        /* For IntelliJ use this */
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
