package task_04;

public class MyThread extends Thread{

    @Override
    public void run(){
        for(int i=0; i<1000000; i++){
            Main.getCounter().incrementAndGet();
        }
    }
}
