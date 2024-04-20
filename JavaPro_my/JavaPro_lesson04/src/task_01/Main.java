package task_01;

public class Main {
    public static void main(String[] args) {

        // 1. Способ
        MyThread1 myThread1 = new MyThread1();

        // 2. Способ
        MyThread2 myThread2 = new MyThread2();
        Thread thread = new Thread(myThread2);


        // myThread1.run();  -> это не многопоточность
        myThread1.start();
        thread.start();

        for(int i=0; i<10; i++){
            System.out.println("Главный поток: " + i);
            try {
                Thread.sleep(300);
            }catch (Exception ignored){

            }
        }
    }
}
