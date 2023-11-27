package program6.service;

import java.util.ArrayList;

import program6.adtInterface.Queue;

public class OperatorService<T> implements Queue<T> {

    private ArrayList<T> queue;

    public OperatorService() {
        queue = new ArrayList<>();
    }

    @Override
    public void enqueue(T element) {
        queue.add(element);
        System.out.println("Ticket Generated for customer: " + element.toString());
    }

    @Override
    public T dequeue() {
        if (queue.isEmpty()) {
            System.out.println("No customers in queue");
            return null;
        }
        T element = queue.remove(0);
        System.out.println("Ticket Served for customer: " + element.toString());
        return element;
    }
    
}
