/*
Title     : Two Strings
Subdomain : Dictionaries and HashMaps
Domain    : Interview Preparation Kit
Author    : Sachin Kumar Tiwari
Problem   : https://www.hackerrank.com/challenges/two-strings/problem
*/

package DictAndHashMap.TwoStrings;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the twoStrings function below.
    static String twoStringsSol_1(String s1, String s2) {
        int s1_len = (s1.length() * (s1.length()+1))/2;
        int s2_len = (s2.length() * (s2.length()+1))/2;
        String s1_str[] = new String[s1_len];
        String s2_str[] = new String[s2_len];
        int k=0;
        String temp="";
        for(int i=0;i<s1.length();i++){
            for(int j=i+1;j<=s1.length();j++){
                temp = s1.substring(i,j);
                if(temp!=null)
                    s1_str[k++]=temp;
            }
        }
        k=0;
        for(int i=0;i<s2.length();i++){
            for(int j=i+1;j<=s2.length();j++){
                temp = s2.substring(i,j);
                if(temp!=null)
                    s2_str[k++]=temp;
            }
        }
        temp="NO";
        for(int i=0;i<s1_str.length;i++){
            if(Arrays.stream(s2_str).anyMatch(s1_str[i]::equals)){
                temp="YES";
                break;
            }
        }
        return temp;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        /* For Hackerrank use this */
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        /* For IntelliJ use this */
        //BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            //String result = twoStringsSol_1(s1, s2);
            //String result = twoStringsSol_2(s1, s2);
            //String result = twoStringsSol_3(s1, s2);
            String result = twoStrings(s1, s2);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
            //System.out.println(result);
        }

        bufferedWriter.close();

        scanner.close();
    }

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        HashSet<Character> s1_charAt = new HashSet<Character>();
        HashSet<Character> s2_charAt = new HashSet<Character>();
        for(int i=0;i<s1.length();i++){
            s1_charAt.add(s1.charAt(i));
        }
        for(int i=0;i<s2.length();i++){
            s2_charAt.add(s2.charAt(i));
        }
        s1_charAt.retainAll(s2_charAt);
        if(!s1_charAt.isEmpty()){
            return "YES";
        }
        return "NO";
    }

    private static String twoStringsSol_3(String s1, String s2) {
        boolean[] letters = new boolean[26];
        for(char c : s1.toCharArray()) letters[c - 'a'] = true;
        for(char c : s2.toCharArray()) if(letters[c - 'a']) return "YES";
        return "NO";
    }

    private static String twoStringsSol_2(String s1, String s2) {
        for(int i=0;i<s1.length();i++){
            for(int j=0;j<s2.length();j++){
                if(s1.charAt(i)==s2.charAt(j)){
                    return "YES";
                }
            }
        }
        return "NO";
    }
}

