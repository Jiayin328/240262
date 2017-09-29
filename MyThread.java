/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countthread;

/**
 *
 * @author Carynne
 */

public class MyThread extends Thread {

    public static void main(String[] args) {
        new Thread(new MyThread()).start();
    }

    @Override
    public void run() {
        try {
            for (int x = 1; x <= 10500; x++) {
                System.out.println(x);
                sleep(5000);
                if (x%50==0){
                    System.out.println("Hello World");
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
