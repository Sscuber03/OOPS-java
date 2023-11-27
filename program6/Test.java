package program6;

import program6.service.OperatorService;

public class Test {
    public static void main(String[] args) {
        OperatorService<String> operator = new OperatorService<>();

        operator.enqueue("A");
        operator.enqueue("B");
        operator.enqueue("C");

        operator.dequeue();
        operator.dequeue();
        operator.dequeue();
        operator.dequeue();

        operator.enqueue("D");

        operator.dequeue();
    }
}
