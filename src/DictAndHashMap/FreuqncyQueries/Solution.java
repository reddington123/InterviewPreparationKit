/*
Title     : Frequency Queries
Subdomain : Dictionaries and HashMaps
Domain    : Interview Preparation Kit
Author    : Sachin Kumar Tiwari
Problem   : https://www.hackerrank.com/challenges/frequency-queries/problem
*/
package DictAndHashMap.FreuqncyQueries;
import javax.print.DocFlavor;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery_sol1(List<List<Integer>> queries) {
        List<Integer> integerList = new LinkedList<Integer>();
        HashMap<Integer,Integer> hashMap = new HashMap<Integer, Integer>();
        int first=0,second=0;
        for(List<Integer> list:queries){
            //System.out.println(list.get(0)+" "+list.get(1));
            first=list.get(0);
            second=list.get(1);
            if(first==1){
                hashMap.put(second,hashMap.getOrDefault(second,0)+1);
            }else if(first==2){
                if(hashMap.containsKey(second) && hashMap.get(second)>=1){
                    hashMap.put(second,hashMap.getOrDefault(second,0)-1);
                }
            }else if(first==3){
                int i=0;
                for(Map .Entry<Integer,Integer> map: hashMap.entrySet()){
                    if(map.getValue()==second){
                        integerList.add(1);
                        break;
                    }
                    i = i+1;
                }
                if(i==hashMap.size()){
                    integerList.add(0);
                }
            }
        }
        return integerList;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        /* For Hackerrank use this */
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        /* For IntelliJ use this */
        //BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        //List<Integer> ans = freqQuery_sol1(queries);
        //List<Integer> ans = freqQuery_sol2(queries);
        List<Integer> ans = freqQuery(queries);

        bufferedWriter.write(
                ans.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();

    }

    private static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> integerList = new LinkedList<Integer>();
        HashMap<Integer,Integer> hashMap = new HashMap<Integer, Integer>();
        int first=0,second=0;
        for(List<Integer> list :queries){
            //System.out.println(list.get(0)+" "+list.get(1));
            first=list.get(0);
            second=list.get(1);
            if(first==1){
                hashMap.put(second,hashMap.getOrDefault(second,0)+1);
            }else if(first==2){
                if(hashMap.containsKey(second) && hashMap.get(second)>=1){
                    hashMap.put(second,hashMap.getOrDefault(second,0)-1);
                }
            }else if(first==3){
                int i=0;
                for(Map .Entry<Integer,Integer> map: hashMap.entrySet()){
                    if(map.getValue()==second){
                        integerList.add(1);
                        break;
                    }
                    i = i+1;
                }
                if(i==hashMap.size()){
                    integerList.add(0);
                }
            }
        }
        return integerList;
    }

    private static List<Integer> freqQuery_sol2(List<List<Integer>> queries) {
        List<Integer> integerList = new LinkedList<Integer>();
        HashMap<Integer,Integer> freq = new HashMap<Integer, Integer>();
        HashMap<Integer,Integer> freq_freq = new HashMap<Integer, Integer>();

        int first=0,second=0;
        int val;
        for(List<Integer> list:queries){
            //System.out.println(list.get(0)+" "+list.get(1));
            first=list.get(0);
            second=list.get(1);
            val=0;
            if(first==1){
                if(freq.containsKey(second) && freq.get(second)>=1){
                    val = freq.get(second);
                }
               freq.put(second,freq.getOrDefault(second,0)+1);
               if(val>0){
                   if(freq_freq.containsKey(val) && freq_freq.get(val-1)>1){
                       freq_freq.put(second,freq_freq.getOrDefault(second,0)-1);
                   }else if(freq_freq.containsKey(val) && freq_freq.get(val-1)<=1){
                       freq_freq.remove(val);
                   }
               }
               freq_freq.put(val+1,freq_freq.getOrDefault(val+1,0)+1);
            }else if(first==2){
                if(freq.containsKey(second) && freq.get(second)>1){
                    val = freq.get(second);
                    freq.put(second,freq.getOrDefault(second,0)-1);
                }else if(freq.containsKey(second) && freq.get(second)<=1){
                    val = freq.get(second);
                    freq.remove(second);
                }
                if(freq_freq.containsKey(val) && freq_freq.get(val)<=1){
                    freq_freq.remove(val);
                }else if(freq_freq.containsKey(val) && freq_freq.get(val)>1){
                    freq_freq.put(val,freq_freq.get(val)-1);
                }
                if(val-1>0)
                    freq_freq.put(val-1,freq_freq.getOrDefault(val-1,0)+1);
            }else if(first==3){
                if(freq_freq.containsKey(second) && freq_freq.get(second)>=1){
                    integerList.add(1);
                }else{
                    integerList.add(0);
                }
            }
        }
        return integerList;
    }
}

