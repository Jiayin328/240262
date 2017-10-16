
package comparethreads;

public class CompareThreads extends Thread{

    static long NorDuration, SyncDuration, begin, end;
    static int count=0;
    
    public static void main(String[] args) throws InterruptedException {
        normal.start();
        normal.join();
        sync.start();
    }
    
    static Thread normal = new Thread (){
        @Override
        public void run(){
            begin = System.nanoTime();
            for(int i=0; i<=10; i++){
                count++;
            }
            end = System.nanoTime();
            NorDuration = end - begin;
            System.out.printf("Normal thread = %.8f seconds. %n", (double)NorDuration/1000000000.0);
        }
    };
        
    static Thread sync = new Thread (){
        @Override
        public void run(){
            begin = System.nanoTime();
            synchronized (this){
                for(int i=0; i<=10; i++){
                    count++;
                }
            }
            end = System.nanoTime();
            SyncDuration = end - begin;
            System.out.printf("Synchronized thread = %.8f seconds. %n", (double)SyncDuration/1000000000.0);
        }
    };
        
    
}
