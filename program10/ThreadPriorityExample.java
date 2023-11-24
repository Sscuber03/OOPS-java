package program10;

class CounterThread extends Thread {
    private static int count = 0;

    public CounterThread(String name, int priority) {
        super(name);
        setPriority(priority);
    }

    @Override
    public void run() {
        while (count < 10) {
            count++;
            System.out.println(Thread.currentThread().getName() + ": Count Value: " + count);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadPriorityExample {
    public static void main(String[] args) {
        CounterThread highPriorityThread = new CounterThread("HighPriorityThread", Thread.MAX_PRIORITY);
        CounterThread lowPriorityThread = new CounterThread("LowPriorityThread", Thread.MIN_PRIORITY);
        CounterThread normalPriorityThread = new CounterThread("NormalPriorityThread", Thread.NORM_PRIORITY);

        highPriorityThread.start();
        lowPriorityThread.start();
        normalPriorityThread.start();

        try {
            highPriorityThread.join();
            lowPriorityThread.join();
            normalPriorityThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main Thread Completed execution");
    }
}
