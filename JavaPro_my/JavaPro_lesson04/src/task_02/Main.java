package task_02;

public class Main {

    public static int counter;

    public static void main(String[] args) {

        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();

        thread1.start();
        thread2.start();

        for(int i=0; i<1000000; i++){
            counter++;
        }

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Значение счетчика - " +  counter);
    }

    public static void increment() {
    }
}
