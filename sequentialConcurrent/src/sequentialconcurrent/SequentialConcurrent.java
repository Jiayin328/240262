package sequentialconcurrent;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SequentialConcurrent extends Thread {
    static ArrayList<Integer> list = new ArrayList<>();
    static int random;
    static long num, begin, end, SeqDuration, ConDuration;

    public static void main(String[] args) throws InterruptedException {
        for (int i=0; i<1000000;i++){
            num = (Math.round(Math.random()*1000000));
            random = (int)(long)num;
            list.add(random);
        }
        sequential.start();
        concurrent.start();        
    }
    
    static Thread sequential = new Thread(){
        public void run(){
            int max = 1;
            begin = System.nanoTime();
            for (int i=0; i<list.size();i++){
                if (list.get(i)>max){
                    max = list.get(i);
                }
            }
            end = System.nanoTime();
            SeqDuration = end - begin;
            System.out.printf("Sequential Program = %.8f seconds.%n", (double)SeqDuration/1000000000.0);
            //System.out.printf("Maximum number is %s. %n", max);
        }
    };
    
    static Thread concurrent = new Thread(){
        public void run() {
            ExecutorService executor = Executors.newSingleThreadExecutor();
            executor.submit(() ->{
                begin = System.nanoTime();
                int max = 1;
                for (int i=0; i<list.size(); i++) {
                    if (list.get(i)>max){
                        max = list.get(i);
                    }
                }
                Thread.currentThread().getName();
                end = System.nanoTime();
                ConDuration = end - begin;
                System.out.printf("Concurrent Program = %.8f seconds.%n", (double)ConDuration/1000000000.0);
                //System.out.printf("Maximum number is %s. %n", max);
            });
            executor.shutdown();
        }
    };
}
