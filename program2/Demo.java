package program2;

class Box {
    private double length;
    private double breadth;
    private double height;

    Box(double l, double b, double h) {
        this.length = l;
        this.breadth = b;
        this.height = h;
    }

    Box(double s) {
        this.length = this.breadth = this.height = s;
    }

    Box() {
        this.length = this.breadth = this.height = 1.0;
    }

    Box(Box b) {
        this.length = b.length;
        this.breadth = b.breadth;
        this.height = b.height;
    }

    public void displayVolume() {
        System.out.println("Volume of the box is: " + this.length * this.breadth * this.height);
    }
}

public class Demo {
    public static void main(String[] args) {
        Box b1 = new Box(10, 20, 30);
        Box b2 = new Box(10);
        Box b3 = new Box();
        Box b4 = new Box(b1);
        System.out.println("Box 1:");
        b1.displayVolume();
        System.out.println("Box 2:");
        b2.displayVolume();
        System.out.println("Box 3:");
        b3.displayVolume();
        System.out.println("Box 4: (copy of Box 1)");
        b4.displayVolume();
    }
}
