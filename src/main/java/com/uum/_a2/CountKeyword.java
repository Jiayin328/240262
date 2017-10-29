//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment2
//Matric: #240262
//Name: #Yap Jia Yin

package com.uum._a2;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class CountKeyword extends Asg2 {
    
    int counter = 0;
        
    public Map<String, Integer> countKeywords() throws FileNotFoundException{
        String keywords[] = {"abstract","assert","boolean","break","byte","case",
            "catch","char","class","continue","default","do","double","else",
            "enum","extends","final","finally","float","for","if","implements",
            "import","instanceof","int","interface","long","native","new","package",
            "private","protected","public","return","short","static","strictfp",
            "super","switch","synchronized","this","throw","throws","transient",
            "try","void","volatile","while","true","null","false","const","goto"};
        Map<String,Integer> map = new TreeMap<>();
        Set<String> keywordSet = new HashSet<>(Arrays.asList(keywords));
        Scanner input = new Scanner(FILE);
        while (input.hasNext()){ 
            String key = input.next();
            if (key.length() > 0){
                if (keywordSet.contains(key)){
                    Integer value = map.get(key);
                    counter++;
                    if (value == null)
                        value = 0;
                    value++;
                    map.put(key, value);
                }
            }
        }
        return map;
    }
    
    public int noKeywords (){
        return counter;
    }
}

