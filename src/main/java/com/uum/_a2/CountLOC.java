//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment2
//Matric: #240262
//Name: #Yap Jia Yin

package com.uum._a2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class CountLOC extends Asg2{
    
    public int countLineNumber() {
        int lines = 0;
        
        try(LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(FILE))) {
            long skip = lineNumberReader.skip(Long.MAX_VALUE);
            lines = lineNumberReader.getLineNumber()+1;
        }catch(FileNotFoundException e){
            System.out.println("FileNotFoundException Occurred" + e.getMessage());
        }catch(IOException e){
            System.out.println("IOException Occurred" + e.getMessage());
        }
        return lines;
    }

    public int countBlankLineNumber() {
        String line;
        int empty = 0;

        try{
            BufferedReader br;
            br = new BufferedReader(new FileReader(FILE));
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                  empty++;
                }
            }
        }catch(FileNotFoundException e){
            System.out.println("FileNotFoundException Occurred" + e.getMessage());
        }catch(IOException e){
            System.out.println("IOException Occurred" + e.getMessage());
        }
        return empty;
    }

    public int countCommentLineNumber() {
        String line;
        int count = 0;

        try(BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            while ((line = br.readLine()) != null) {
                if (line.startsWith("//")) 
                  count++;
                if (line.startsWith("/*")) {
                    count++;
                    while (!(line = br.readLine()).endsWith("'*\'")) {
                        count++; break;
                    }
                }
            }
        }catch(FileNotFoundException e){
            System.out.println("FileNotFoundException Occurred" + e.getMessage());
        }catch(IOException e){
            System.out.println("IOException Occurred" + e.getMessage());
        }
        return count;
    }
}
