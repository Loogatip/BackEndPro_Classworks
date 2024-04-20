package task_04;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    private static AtomicInteger counter = new AtomicInteger(0);

    public static AtomicInteger getCounter(){
        return counter;
    }
    public static void main(String[] args) {

        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();

        thread1.start();
        thread2.start();

        for(int i=0; i<1000000; i++){
            counter.incrementAndGet();
        }

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Значение счетчика - " +  counter);
    }
}
