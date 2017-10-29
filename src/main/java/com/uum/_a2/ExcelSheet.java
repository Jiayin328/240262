//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment2
//Matric: #240262
//Name: #Yap Jia Yin

package com.uum._a2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelSheet{

    XSSFWorkbook workbook = new XSSFWorkbook();;
    XSSFSheet sheet = workbook.createSheet("Line of Codes");
    
    String fileName;
    String detail[][];
    String attribute[][];
    String data[][];
    String output[][];
    
    public ExcelSheet(String filename) {
        sheet.setDefaultColumnWidth(10);
        this.fileName = filename;
    }
    
    public String[][] details(String semester, String course, String group, String task) {
        detail = new String[][] {{"Semester",semester},{"Course",course},{"Group",group},
            {"Task",task},{}};
        return detail;
    }
    
    public ExcelSheet data(Map<String, Integer> map, String name, String matric, 
            String loc, String blank, String comment, String actLoc, String ttl) {
        
        String key[] = new String [map.size()];
        String value[] = new String [map.size()];
        
        int a = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            key[a] = entry.getKey();
            value[a] = Integer.toString(entry.getValue());
            a++;
        }
        
        //attributes
        String attributes[] = new String[key.length + 6];
        attributes[0] = "Matrix";
        attributes[1] = "LOC";
        attributes[2] = "Blank";
        attributes[3] = "Comment";
        attributes[4] = "Actual LOC";
        for (int i=5; i<(attributes.length-1); i++) {
            attributes[i] = key[(i-5)];
        }
        attributes[5 + key.length] = "Total";
        String attributeList[][] = {{"","","","","","Java keywords"},attributes};
    
        //data
        String [] datas = new String [value.length + 6];
        datas[0]=matric;
        datas[1]=loc;
        datas[2]=blank;
        datas[3]=comment;
        datas[4]=actLoc;
        for (int i=5; i<(datas.length-1); i++) {
            datas[i] = value[(i-5)];
        }
        datas[5 + value.length] = ttl;
        String dataList[][] = {datas};
        
        this.data = dataList;
        this.attribute = attributeList;
        return this;
    }
    
    public void arrange() {

        output = new String[detail.length + attribute.length + data.length][];
        int i = 0;
        for (; i < detail.length; i++) {
            output[i] = new String[detail[i].length];
            for (int b = 0; b < detail[i].length; b++) {
                output[i][b] = detail[i][b];
            }
        }
        for (String[] Attribute1 : attribute) {
            output[i] = Attribute1;
            i++;
        }
        for (String[] Data1 : data) {
            output[i] = Data1;
            i++;
        }

        int rowNum = 0;
        for (Object[] attributesA : output) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (Object field : attributesA) {
                Cell cell = row.createCell(colNum++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
        }
    
        try {
            FileOutputStream outputStream = new FileOutputStream(fileName);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
