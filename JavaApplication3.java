/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

/**
 *
 * @author master lab
 */
public class JavaApplication3 extends Thread {

    /**
     * @param args the command line arguments
     */
    int x=0;
    
    public void printA(int a){
        if (a==5){
            for (int y=0;y<10;y++){
                System.out.print("A");
            }
            System.out.print(" ");
        }
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
         new Thread(new JavaApplication3()).start();
    }
    
    
    @Override
    public void run() {
        try {
            for (x = 0; x < 10; x++) {
                System.out.print((x+1) + " ");
                sleep(2000);
                printA(x+1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
