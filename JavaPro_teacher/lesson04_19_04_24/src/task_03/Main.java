package task_03;

public class Main {

    private static int counter;

    public static synchronized void increment() {
        counter++;
    }

    public static void main(String[] args) {

        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();

        thread1.start();
        thread2.start();

        for (int i = 0; i < 1_000_000; i++) {
            increment();
        }

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Значение счётчика - " + counter);
    }
}