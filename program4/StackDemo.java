package program4;

class Stack {
    Object arr[];
    int top;
    int size;

    Stack(int size) {
        this.size = size;
        arr = new Object[size];
        top = -1;
    }

    void push(Object x) {
        if (top == size - 1) {
            System.out.println("Stack overflow");
            return;
        }
        arr[++top] = x;
        System.out.println("Pushed " + x);
    }

    Object pop() {
        if (top == -1) {
            System.out.println("Stack underflow");
            return null;
        }
        return arr[top--];
    }

    void display() {
        System.out.println("The stack is:");
        for (int i = 0; i < top; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println(arr[top]);
    }
}

public class StackDemo {
    public static void main(String[] args) {
        Stack s = new Stack(5);
        s.push(1);
        s.push('a');
        s.push("Hello");
        s.display();
        System.out.println("Popped " + s.pop());
        s.push(3.14);
        s.push(true);
        s.display();
        System.out.println("Popped " + s.pop());
        s.display();
    }
}

