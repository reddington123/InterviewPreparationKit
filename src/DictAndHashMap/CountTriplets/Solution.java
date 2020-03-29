/*
Title     : Count Triplets
Subdomain : Dictionaries and HashMaps
Domain    : Interview Preparation Kit
Author    : Sachin Kumar Tiwari
Problem   : https://www.hackerrank.com/challenges/count-triplets-1/problem
*/
package DictAndHashMap.CountTriplets;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the countTriplets function below.
    static long countTriplets_sol1(List<Long> arr, long r) {
        ArrayList<Long> arrayList = new ArrayList<>();
        long val=0,res=0;
        HashMap<Long, Integer> hashMap = new HashMap<>();
        for(long i=0;i<arr.size();i++){
            val=calculate_power(arr.get((int) i),r);
            if(!hashMap.containsKey(val)){
                hashMap.put(val,1);
            }else{
                hashMap.put(val,hashMap.get(val)+1);
            }
        }
        for(long i=0;i<hashMap.size()-2;i++){
            res += hashMap.get(i)*hashMap.get(i+1)*hashMap.get(i+2);
        }
        return res;
    }

    private static long calculate_power(Long aLong, long r) {
        long res = 0;
        while(aLong>=r){
            aLong /= r;
            res += 1;
        }
        return  res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        /* For Hackerrank use this */
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        /* For IntelliJ use this */
        //BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        //long ans = countTriplets_sol1(arr, r);
        //long ans = countTriplets_sol2(arr, r);
        //long ans = countTriplets_sol3(arr, r);
        long ans = countTriplets(arr, r);
        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    private static long countTriplets(List<Long> arr, long r) {
        long res=0;
        HashMap<Long,Long> leftHashMap= new HashMap<Long, Long>();
        HashMap<Long,Long> rightHashMap= new HashMap<Long, Long>();

        for(long val:arr){
            rightHashMap.put(val,rightHashMap.getOrDefault(val,0L)+1);
        }
        long left=0,right=0,mid;
        for(int i=0;i<arr.size();i++){
            left=0;
            right=0;
            mid = arr.get(i);
            rightHashMap.put(mid,rightHashMap.getOrDefault(mid,0L)-1);
            if(leftHashMap.containsKey(mid/r) &&  (mid%r)==0){
                left = leftHashMap.get(mid/r);
            }
            if(rightHashMap.containsKey(mid*r)){
                right = rightHashMap.get(mid*r);
            }
            leftHashMap.put(mid,leftHashMap.getOrDefault(mid,0L)+1);
            res += left * right;
        }
        return res;
    }

    private static long countTriplets_sol3(List<Long> arr, long r) {
        long res=0;
        HashMap<Long,Long> leftHashMap= new HashMap<Long, Long>();
        HashMap<Long,Long> rightHashMap= new HashMap<Long, Long>();

        for(long val:arr){
            rightHashMap.put(val,rightHashMap.getOrDefault(val,0L)+1);
        }
        long left=0,right=0,mid;
        for(int i=0;i<arr.size();i++){
            left=0;
            right=0;
            mid = arr.get(i);
            //rightHashMap.put(mid,rightHashMap.getOrDefault(mid,0L)-1);
            if(leftHashMap.containsKey(mid/r) &&  (mid%r)==0){
                left = leftHashMap.get(mid/r);
            }
            leftHashMap.put(mid,leftHashMap.getOrDefault(mid,0L)+1);//Yaad rakho
            if(rightHashMap.containsKey(mid*r)){
                right = rightHashMap.get(mid*r);
            }
            rightHashMap.put(mid,rightHashMap.getOrDefault(mid,0L)-1); // Yaad rakho
            //leftHashMap.put(mid,leftHashMap.getOrDefault(mid,0L)+1);
            res += left * right;
        }
        return res;
    }

    private static long countTriplets_sol2(List<Long> arr, long r) {
        HashMap<Long, Long> hashMap = new HashMap<>();
        long res=0;
        for(int i=0;i<arr.size();i++){
            if(!hashMap.containsKey(arr.get(i))){
                hashMap.put(arr.get(i),(long)1);
            }else{
                hashMap.put(arr.get(i),hashMap.get(arr.get(i))+1);
            }
        }
        for(Map.Entry<Long, Long> map : hashMap.entrySet()){
            long firstKey = map.getKey();
            long secondKey = firstKey*r;
            long thirdKey = secondKey*r;
            if( hashMap.containsKey(secondKey) && hashMap.containsKey(thirdKey) ){
                //System.out.println("first = "+firstKey+" second = "+secondKey+" third = "+thirdKey);
                res += hashMap.get(firstKey)*hashMap.get(secondKey)*hashMap.get(thirdKey);
            }
        }
        return res;
    }
}