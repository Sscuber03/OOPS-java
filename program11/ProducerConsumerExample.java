package program11;

class SharedResource {
    private int x;
    private boolean produced;

    public synchronized void produce() {
        while(produced) {
            try {
                wait();
            } catch(InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        x++;
        System.out.println("Produced: " + x);
        produced = true;
        notify();
    }

    public synchronized void consume() {
        while(!produced) {
            try {
                wait();
            } catch(InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Consumed: " + x);
        produced = false;
        notify();
    }
}

class Producer extends Thread {
    private SharedResource sharedResource;

    public Producer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        while(true) {
            sharedResource.produce();
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class Consumer extends Thread {
    private SharedResource sharedResource;

    public Consumer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        while(true) {
            sharedResource.consume();
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class ProducerConsumerExample {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        
        Producer producer = new Producer(sharedResource);
        Consumer consumer = new Consumer(sharedResource);

        producer.start();
        consumer.start();
    }
}
