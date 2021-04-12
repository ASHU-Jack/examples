package bq.example;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{

	protected BlockingQueue<String> queue = null;
	protected String threadName;

    public Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }
    
    public String getThreadName() {
		return threadName;
	}

	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}



	public void run() {
        try {
            queue.put("1");
            System.out.println("Produced 1 now sleeping");
            Thread.sleep(1000);
            queue.put("2");
            System.out.println("Produced 2 now sleeping");
            Thread.sleep(1000);
            queue.put("3");
            System.out.println("Produced 3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
