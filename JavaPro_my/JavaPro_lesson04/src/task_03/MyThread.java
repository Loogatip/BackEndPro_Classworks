package task_03;

public class MyThread extends Thread{

    @Override
    public void run(){
        for(int i=0; i<1000000; i++){
            Main.increment();
        }
    }
}
