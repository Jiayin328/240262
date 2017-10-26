package counttotalrandomnumoftwothreads;

public class CountTotalRandomNumOfTwoThreads{
    
    public static void main(String[] args) throws Exception{
        
        CountThread c = new CountThread();
        Thread t1 = new Thread(c, "Thread-1");
        Thread t2 = new Thread(c, "Thread-2");
        
        t1.start();
        t2.start();
        
        t1.join();
        t2.join();
        
        System.out.println(t1.getName()+ " = " + c.getT1());
        System.out.println(t2.getName()+ " = " + c.getT2());
        System.out.println("Total = " + (c.getT1()+c.getT2()));
    }  
    
}
