package program8;
import java.util.Scanner;
// InvalidInputException class

class InvalidInputException extends Exception {
    private int input;

    public InvalidInputException(int input) {
        this.input = input;
    }

    @Override
    public String toString() {
        return "InvalidInputException[" + input + "]";
    }
}

// TestPrime class

class TestPrime {
    public static boolean isPrime(int n) throws InvalidInputException {
        if (n <= 0) {
            throw new InvalidInputException(n);
        }
        for (int i = 2; i <= Math.sqrt(n); ++i) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int input = sc.nextInt();
        try {
            boolean isInputPrime = TestPrime.isPrime(input);
            System.out.println(input + " is prime: " + isInputPrime);
        } catch (InvalidInputException e) {
            System.out.println(e);
        }
        sc.close();
    }
}
