package by.itacademy.company.Thread;

public class ThreadCounter extends Thread {

    @Override
    public void run() {
        int counter = 0;
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.printf("\nВремя выполнения программы: %d сек.", counter);
                break;
            }
            ++counter;
            if (ThreadCounter.currentThread().isInterrupted()) {
                break;
            }
        }
    }
}