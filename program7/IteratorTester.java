package program7;

class DataStructure {
    private int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

    void display() {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        EvenIterator evenIterator = new EvenIterator();
        evenIterator.display();
    }

    private class EvenIterator {
        void display() {
            System.out.println("Even Iterator: ");
            for(int i = 0; i < arr.length; i += 2) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}

public class IteratorTester {
    public static void main(String[] args) {
        DataStructure dataStructure = new DataStructure();
        dataStructure.display();
    }
}

