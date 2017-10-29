//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment2
//Matric: #240262
//Name: #Yap Jia Yin

package com.uum._a2;

import java.io.File;
import java.util.LinkedList;

public class ListFiles extends Asg2{
    static LinkedList list = new LinkedList();
    
    static String listFiles(String PATH) {
        File folder = new File(PATH);
        File[] files = folder.listFiles();
            
        for (File file : files) {
            if (file.isFile() && (file.getName().endsWith(".java"))) { 
                list.add(file.getName());
            } else if (file.isDirectory()) {
                listFiles(file.getAbsolutePath());
            }
        } 
        
        return PATH + File.separator + list.get(0);
        //return PATH + File.separator + list.get(1);
    }

    
}
