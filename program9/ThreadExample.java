package program9;
import java.util.Scanner;

class FactorialThread extends Thread {
    private int n;
    private int res;

    public FactorialThread(int n) {
        this.n = n;
        this.res = 1;
    }

    @Override
    public void run() {
        for (int i = 2; i <= n; ++i) {
            res *= i;
        }
        System.out.println("Factorial of " + n + " is " + res);
    }

    public int getFactorial() {
        return res;
    }
}

class FactorsThread extends Thread {
    private int n;

    public FactorsThread(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        System.out.print("Factors of " + n + ": ");
        for (int i = 1; i <= n; ++i) {
            if (n % i == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}

public class ThreadExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int input = sc.nextInt();

        FactorialThread factorialThread = new FactorialThread(input);
        FactorsThread factorsThread = new FactorsThread(input);

        factorialThread.start();
        factorsThread.start();

        try {
            factorialThread.join();
            factorsThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main Thread Completed execution");
        sc.close();
    }
}
