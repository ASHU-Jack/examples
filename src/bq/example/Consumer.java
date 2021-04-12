package bq.example;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

    protected BlockingQueue<String> queue = null;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            System.out.println("Consumed " + queue.take());
            System.out.println("Consumed " + queue.take());
            System.out.println("Consumed " + queue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
