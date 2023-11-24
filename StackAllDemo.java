import java.util.*;

class StackAll {
    Object arr[];
    int top;

    StackAll(int size) {
        arr = new Object[size];
        top = -1;
    }

    void push(Object x) {
        if (top == arr.length - 1) {
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
        for (int i = top; i >= 0; i--) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }
}

public class StackAllDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the stack");
        int size = sc.nextInt();
        StackAll s = new StackAll(size);
        System.out.println("Enter the elements of the stack");
        for (int i = 0; i < size; i++) {
            s.push(sc.next());
        }
        s.display();
        System.out.println("Popped " + s.pop());
        s.display();
    }
}
