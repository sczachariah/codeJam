package com.sczachariah;


import java.util.HashMap;

public class DuplicateInString {

    public static void main(String ... args){
        String s = "abcba1312";

        HashMap<Character, Integer> dupMap = new HashMap<Character, Integer>();
        char[] chrs = s.toCharArray();
        for(Character ch:chrs){
            if(dupMap.containsKey(ch)){
                dupMap.put(ch, dupMap.get(ch)+1);
            } else {
                dupMap.put(ch, 1);
            }
        }
        System.out.println(dupMap.entrySet());
    }
}
