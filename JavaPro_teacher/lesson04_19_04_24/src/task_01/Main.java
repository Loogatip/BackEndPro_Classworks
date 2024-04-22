package task_01;

public class Main {

    public static void main(String[] args) {

        // Два базовых способа создания отдельного потока:
        // 1. Наследуемся от класса Thread
        // 2. Реализуем интерфейс Runnable

        // 1. Создаём объект нашего класса и вызываем его метод start
        MyThread1 myThread1 = new MyThread1();

        // 2. Создаём объект нашего класса и передаём его в конструктор
        // класса Thread, а затем вызываем метод start у объекта класса Thread
        MyThread2 myThread2 = new MyThread2();
        Thread thread = new Thread(myThread2);

        myThread1.start();
        thread.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("Главный поток: " + i);
            try {
                Thread.sleep(300);
            } catch (Exception ignored) {

            }
        }
    }
}