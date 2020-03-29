/*
Title     : Sherlock and Anagram
Subdomain : Dictionaries and HashMaps
Domain    : Interview Preparation Kit
Author    : Sachin Kumar Tiwari
Problem   : https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem
*/
package DictAndHashMap.SherlockAndAnagram;

import java.io.*;
import java.math.*;
import java.security.*;
import java.sql.Array;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams_sol1(String s) {
        String temp="";
        String sorted_temp="";
        HashMap<String,Integer> hashMap = new HashMap<String, Integer>();
        char tempArray[];
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<s.length()+1-i;j++){
                temp=s.substring(j,j+i);
                if(temp!=null){
                    tempArray=temp.toCharArray();
                    Arrays.sort(tempArray);
                    sorted_temp=String.valueOf(tempArray);
                    System.out.println("At i = "+i+" j = "+j+" sorted_temp = "+sorted_temp+" temp = "+temp);
                    if(!hashMap.containsKey(sorted_temp)){
                        hashMap.put(sorted_temp,1);
                    }else{
                        hashMap.put(sorted_temp,hashMap.get(sorted_temp)+1);
                    }
                }
            }
        }
        int res=0;
        for(Map.Entry<String, Integer> m :hashMap.entrySet()){
            System.out.println("key  = "+m.getKey()+" value = "+m.getValue());
            res+=m.getValue();
        }
        return res;
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
            String s = scanner.nextLine();

            //int result = sherlockAndAnagrams_sol1(s);
            //int result = sherlockAndAnagrams_sol2(s);
            //int result = sherlockAndAnagrams_sol3(s);
            //int result = sherlockAndAnagrams_sol4(s);
            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }

    private static int sherlockAndAnagrams(String s) {
        String temp="";
        int res=0;
        String s1="",s2="";
        ArrayList<String> arrayList = new ArrayList<>();
        for(int len=1;len<s.length();len++){
            for(int i=0;i<s.length()-len;i++){
                s1=s.substring(i,i+len);
                for(int j=i+1;j<s.length()+1-len;j++){
                    s2=s.substring(j,j+len);
                    res+=isAnagram(s1,s2);
                    /*temp=s.substring(i,j);
                    if(temp!=null){
                        arrayList.add(temp);
                    }*/
                }
            }
        }
        /*
        for(int i=0;i<arrayList.size()-1;i++){
            for(int j=i+1;j<arrayList.size();j++){
                res += isAnagram(arrayList.get(i),arrayList.get(j));
            }
        }*/
        //System.out.println(arrayList.toString());
        return res;
    }

    private static int sherlockAndAnagrams_sol4(String s) {
        String temp="";
        int res=0;
        String s1="",s2="";
        ArrayList<String> arrayList = new ArrayList<>();
        for(int len=1;len<s.length();len++){
            for(int i=0;i<s.length()-len;i++){
                s1=s.substring(i,i+len);
                for(int j=i+1;j<s.length()+1-len;j++){
                    s2=s.substring(j,j+len);
                    res+=isAnagram(s1,s2);
                }
            }
        }
        return res;
    }

    private static int sherlockAndAnagrams_sol3(String s) {
        String temp="";
        int res=0;
        HashMap<String,Integer> hashMap = new HashMap<String, Integer>();
        char temp_arr[];
        ArrayList<String> arrayList = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<s.length()+1;j++){
                temp=s.substring(i,j);
                if(temp!=null){
                    temp_arr=temp.toCharArray();
                    System.out.println("At i = "+i+" j = "+j+" before sorting temp = "+temp);
                    Arrays.sort(temp_arr);
                    temp=String.valueOf(temp_arr);
                    System.out.println("At i = "+i+" j = "+j+" after sorting temp = "+temp);
                    //arrayList.add(temp);
                    if(!hashMap.containsKey(temp)){
                        hashMap.put(temp,1);
                    }else{
                        if(hashMap.get(temp)==1){
                            res += 1;
                            hashMap.remove(temp);
                        }
                    }
                }
            }
        }
        /*
        for(int i=0;i<arrayList.size()-1;i++){
            for(int j=i+1;j<arrayList.size();j++){
                res += isAnagram(arrayList.get(i),arrayList.get(j));
            }
        }*/
        //System.out.println(arrayList.toString());
        return res;
    }

    private static  int isAnagram(String s1,String s2) {
        int res = 1;
        Character c;
        int arr[] = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            arr[s1.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < s2.length(); i++) {
            arr[s2.charAt(i) - 'a'] -= 1;
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) {
                res = 0;
                return res;
            }
        }
        return res;
    }
        /*
        HashMap<Character,Integer> hashMap = new HashMap<Character, Integer>();
        for(int i=0;i<s1.length();i++){
            c=s1.charAt(i);
            if(!hashMap.containsKey(c)) {
                hashMap.put(s1.charAt(i), 1);
            }else{
                hashMap.put(s1.charAt(i), hashMap.get(s1.charAt(i)) + 1);
            }
        }
        for(int j=0;j<s2.length();j++){
            c=s2.charAt(j);
            if(!hashMap.containsKey(c)){
                res=0;
                return res;
            }else{
                hashMap.put(c,hashMap.get(c)-1);
            }
        }
        if(!hashMap.isEmpty()){
            return 0;
        }
        return res;
    }*/
    private static int sherlockAndAnagrams_sol2(String s) {
        int total_subsequence = calculatePowerOf2(s.length());
        int len = s.length();
        HashMap<String,Integer> hashMap = new HashMap<String, Integer>();
        String temp="";
        for(int i=1;i<total_subsequence;i++){
            temp = cal_subsequence(s,i,len);
            char m[] = temp.toCharArray();
            Arrays.sort(m);
            temp= String.valueOf(m);
            if(!hashMap.containsKey(temp)){
                hashMap.put(temp,1);
            }else{
                hashMap.put(temp,hashMap.get(temp)+1);
            }
            System.out.println("At i = "+i+" temp = "+temp);
        }
        for(Map.Entry<String, Integer> map: hashMap.entrySet()){
            System.out.println(" Key = "+map.getKey()+" value = "+map.getValue());
        }
        return 0;
    }

    private static String cal_subsequence(String s, int i, int len) {
        String res="";
        for(int j=0;j<len;j++){
            if( (i & (1<<j) )>= 1){
                res += s.charAt(j);
            }
        }
        return res;
    }

    private static int calculatePowerOf2(int s) {
        int res=1;
        for(int i=0;i<s;i++){
            res = res * 2;
        }
        return res;
    }
}