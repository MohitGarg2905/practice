package com.tryout.other.interview.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Mohit Garg (mohit.garg2905@gmail.com)
 * @createdAt: 2019-Jul-25 4:54 PM
 */
public class GenerateDictionary {

    public static void main(String[] arg) {
        System.out.println("Hello, world!");
        String[] args = {"ABB", "ACA", "BFCA", "BFDA", "DAD", "DAF", "DFAC"};
        Map<String, List<Character>> map = new HashMap();
        Boolean lengthIsLess = false;
        int j= 0;

        while(!lengthIsLess){
            for(int i=0; i<args.length; i++){
                if(args[i].length()<=j){
                    lengthIsLess =  true;
                } else {
                    lengthIsLess = false;
                    if(j==0){
                        List<Character> l = map.getOrDefault("", new ArrayList<Character>());
                        l.add(args[i].charAt(j));
                        map.put("", l);
                    } else {
                        List<Character> l = map.getOrDefault(args[i].substring(0, j), new ArrayList<Character>());
                        l.add(args[i].charAt(j));
                        map.put(args[i].substring(0, j), l);
                    }
                }
            }
            j++;

        }


        List<Character> output = new ArrayList<Character>();

        for(Map.Entry<String, List<Character>> entry:map.entrySet()){
            output = merge(output, entry.getValue());
        }

        for(Character c: output){
            System.out.println(c);
        }

    }


    public static List<Character> merge(List<Character> init, List<Character> toMerge){
        if(init==null ){
            init = new ArrayList();
        }
        Character p;
        Character c;
        int indexOfP = -1;
        int indexOfC = 0;
        for(int i=0; i<toMerge.size(); i++){
            c = toMerge.get(i);
            indexOfC = init.indexOf(c);
            if(i==0 && indexOfC==-1){
                init.add(0, c);
            }else if(i!=0){
                p = toMerge.get(i-1);
                indexOfP = init.indexOf(p);
                if(indexOfP==-1 || indexOfP>indexOfC || indexOfC==-1){
                    if(indexOfC>-1)
                        init.remove(c);
                    if(indexOfP<init.size()-1)
                        init.add(indexOfP+1, c);
                    else
                        init.add(c);
                }
            }

        }
        return init;
    }
}
