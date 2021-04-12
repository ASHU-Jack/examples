package bq.example;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BlockingQueueExample {

	public static void main(String[] args) throws Exception {

        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1024);

//        Producer producer = new Producer(queue);
//        Consumer consumer = new Consumer(queue);

        // creates 3 producers
        Runnable pr1 = new Producer(queue);
        Runnable pr2 = new Producer(queue);
        Runnable pr3 = new Producer(queue);
          
        // creates 3 consumer
        Runnable cr1 = new Consumer(queue);
        Runnable cr2 = new Consumer(queue);
        Runnable cr3 = new Consumer(queue);
        
        
        // creates a thread pool with 3 threads
        ExecutorService producerPool = Executors.newFixedThreadPool(3); 
        ExecutorService consumerPool = Executors.newFixedThreadPool(3); 
        
     // passes the Task objects to the pool to execute
        producerPool.execute(pr1);
        producerPool.execute(pr2);
        producerPool.execute(pr3);
        
        Thread.sleep(4000);
        
        consumerPool.execute(cr1);
        consumerPool.execute(cr2); 
        consumerPool.execute(cr3); 
          
        // producerPool shutdown
        producerPool.shutdown();   
        // producerPool shutdown
        consumerPool.shutdown();    
    }
}
