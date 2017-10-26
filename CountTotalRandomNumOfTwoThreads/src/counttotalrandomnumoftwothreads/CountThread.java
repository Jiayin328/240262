package counttotalrandomnumoftwothreads;

import java.util.concurrent.atomic.AtomicInteger;

public class CountThread implements Runnable{

    int T1, T2, Total;
    AtomicInteger total = new AtomicInteger();
    AtomicInteger countT1 = new AtomicInteger();
    AtomicInteger countT2 = new AtomicInteger();
    
    @Override
    public void run() {
        while(Total < 1000){
            Total = total.incrementAndGet();
            int random = getRandomInteger(3000, 500);
            
            if(Thread.currentThread().getName().equals("Thread-1")){
                T1 = countT1.incrementAndGet();
            }else if(Thread.currentThread().getName().equals("Thread-2")){
                T2 = countT2.incrementAndGet();
            }
        
            if(countT1.get() > countT2.get()){
                T1 = countT1.decrementAndGet();
                T2 = countT2.incrementAndGet();
            }
        }
    }
    
    public static int getRandomInteger(int max, int min){
        return ((int) (Math.random()*(max - min))) + min;
    }

    int getT1() {
        return T1;
    }

    int getT2() {
        return T2;
    }

}
