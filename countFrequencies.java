/* Problem: count frequencies of all elements in an array of numbers
   Solution: use hash tables; T(n) = O(n)
   This is the Java version of countFrequencie.cpp
*/

import java.util.*;

public class CountFrequencies {
   public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,2,3,1,8,11,0,3,-1,-2};
        Hashtable<Integer, Integer> counts = count(arr);
        
        Enumeration keys = counts.keys();
        
        while(keys.hasMoreElements()){
            Integer key = (Integer) keys.nextElement();
            System.out.println(key + " " + counts.get(key));
        }
   }
    
   public static Hashtable<Integer, Integer> count(int[] arr){
       
       Hashtable<Integer, Integer> ret = new Hashtable<Integer, Integer>();
       
       for(int i=0; i<arr.length; i++){
           Integer n = ret.get(arr[i]);
           
           if(n == null){
               ret.put(arr[i], 1);
           }
           else{
               ret.put(arr[i], n.intValue()+1);
           }
       }
       
       return ret;
   }
}
