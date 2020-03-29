/*
Title     : Hash Tables Ransom Notes
Subdomain : Dictionaries and HashMaps
Domain    : Interview Preparation Kit
Author    : Sachin Kumar Tiwari
Problem   : https://www.hackerrank.com/challenges/ctci-ransom-note/problem
*/
package DictAndHashMap.HashTables_RansomNotes;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        HashMap<String,Integer> hashMap = new HashMap<>();
        String res="Yes";
        for(int i=0;i<magazine.length;i++){
            if(!hashMap.containsKey(magazine[i])){
                hashMap.put(magazine[i],1);
            }else{
                hashMap.put(magazine[i],hashMap.get(magazine[i])+1);
            }
        }
        for(int i=0;i<note.length;i++){
            if(!hashMap.containsKey(note[i])){
                res="No";
                break;
            }else if(hashMap.get(note[i])==0){
                res="No";
                break;
            }else{
                hashMap.put(note[i],hashMap.get(note[i])-1);
            }
        }
        System.out.println(res);
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}