package task_01;

public class MyThread2 implements Runnable{

    @Override
    public void run() {
            for(int i=10000; i<10010; i++){
                System.out.println("Поток 2: " + i);
                try {
                    Thread.sleep(500);
                }catch (Exception ignored){

                }
            }
        }
    }

