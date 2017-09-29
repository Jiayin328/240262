package twothreads;

public class TwoThreads extends Thread {
    
    int x=0;
     
    public static void main(String[] args) {
         new Thread(new TwoThreads()).start();
    }
    
    public void printA(int a){
        if (a==5){
            for (int y=0;y<10;y++){
                System.out.print("A");
            }
            System.out.print(" ");
        }
    }
    
    @Override
    public void run() {
        try {
            for (x = 0; x < 10; x++) {
                System.out.print((x+1) + " ");
                sleep(1000);
                printA(x+1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
