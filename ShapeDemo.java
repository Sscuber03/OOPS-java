class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point p) {
        return Math.sqrt(Math.pow((p.x - this.x), 2) + Math.pow((p.y - this.y), 2));
    }
}

abstract class Shape {
    abstract double area();

    abstract double perimeter();

    abstract String colour();

    abstract String compareShape(Shape s);
}

class Circle extends Shape {
    Point center;
    Point edge;
    String colour;

    public Circle(Point center, Point edge, String colour) {
        this.center = center;
        this.edge = edge;
        this.colour = colour;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(center.distance(edge), 2);
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * center.distance(edge);
    }

    @Override
    public String colour() {
        return colour;
    }

    @Override
    public String compareShape(Shape s) {
        String res = "";
        if (s instanceof Circle) {
            Circle c = (Circle) s;
            if (this.area() == c.area() && this.perimeter() == c.perimeter()) {
                res = "Same Circle";
            } else {
                res = "Different Circle";
            }
        } else {
            res = "Different Shape";
        }
        return res;
    }
}

class Triangle extends Shape {
    Point a;
    Point b;
    Point c;
    String colour;

    public Triangle(Point a, Point b, Point c, String colour) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.colour = colour;
    }

    @Override
    public double area() {
        double s = (a.distance(b) + b.distance(c) + c.distance(a)) / 2;
        return Math.sqrt(s * (s - a.distance(b)) * (s - b.distance(c)) * (s - c.distance(a)));
    }

    @Override
    public double perimeter() {
        return a.distance(b) + b.distance(c) + c.distance(a);
    }

    @Override
    public String colour() {
        return colour;
    }

    @Override
    public String compareShape(Shape s) {
        String res = "";
        if (s instanceof Triangle) {
            Triangle t = (Triangle) s;
            if (this.area() == t.area() && this.perimeter() == t.perimeter()) {
                res = "Same Triangle";
            } else {
                res = "Different Triangle";
            }
        } else {
            res = "Different Shape";
        }
        return res;
    }
}

class Rectangle extends Shape {
    Point a;
    Point b;
    Point c;
    Point d;
    String colour;

    public Rectangle(Point a, Point b, Point c, Point d, String colour) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.colour = colour;
    }

    @Override
    public double area() {
        return a.distance(b) * b.distance(c);
    }

    @Override
    public double perimeter() {
        return 2 * (a.distance(b) + b.distance(c));
    }

    @Override
    public String colour() {
        return colour;
    }

    @Override
    public String compareShape(Shape s) {
        String res = "";
        if (s instanceof Rectangle) {
            Rectangle r = (Rectangle) s;
            if (this.area() == r.area() && this.perimeter() == r.perimeter()) {
                res = "Same Rectangle";
            } else {
                res = "Different Rectangle";
            }
        } else {
            res = "Different Shape";
        }
        return res;
    }
}

public class ShapeDemo {
    public static void main(String[] args) {
        Point cen1 = new Point(0, 0);
        Point edg1 = new Point(0, 3);

        Point cen2 = new Point(0, 0);
        Point edg2 = new Point(0, 4);

        Point cen3 = new Point(0, 0);
        Point edg3 = new Point(4, 0);

        Point a1 = new Point(0, 0);
        Point b1 = new Point(0, 3);
        Point c1 = new Point(4, 0);

        Point a2 = new Point(0, 0);
        Point b2 = new Point(0, 4);
        Point c2 = new Point(5, 0);

        Point a3 = new Point(0, 0);
        Point b3 = new Point(0, 4);
        Point c3 = new Point(3, 0);

        Point p1 = new Point(0, 0);
        Point q1 = new Point(0, 3);
        Point r1 = new Point(4, 3);
        Point s1 = new Point(4, 0);

        Point p2 = new Point(0, 0);
        Point q2 = new Point(0, 4);
        Point r2 = new Point(5, 4);
        Point s2 = new Point(5, 0);

        Point p3 = new Point(0, 0);
        Point q3 = new Point(0, 4);
        Point r3 = new Point(3, 4);
        Point s3 = new Point(3, 0);

        Shape circle1 = new Circle(cen1, edg1, "Red");
        Shape circle2 = new Circle(cen2, edg2, "Blue");
        Shape circle3 = new Circle(cen3, edg3, "Green");

        Shape triangle1 = new Triangle(a1, b1, c1, "Red");
        Shape triangle2 = new Triangle(a2, b2, c2, "Blue");
        Shape triangle3 = new Triangle(a3, b3, c3, "Green");

        Shape rectangle1 = new Rectangle(p1, q1, r1, s1, "Red");
        Shape rectangle2 = new Rectangle(p2, q2, r2, s2, "Blue");
        Shape rectangle3 = new Rectangle(p3, q3, r3, s3, "Green");

        System.out.printf("Circle 1 Area: %.3f \n" , circle1.area());
        System.out.printf("Circle 1 Perimeter: %.3f \n" , circle1.perimeter());
        System.out.printf("Circle 1 Colour: " + circle1.colour());
        System.out.printf("Circle 2 Area: %.3f \n" , circle2.area());
        System.out.printf("Circle 2 Perimeter: %.3f \n" , circle2.perimeter());
        System.out.printf("Circle 2 Colour: " + circle2.colour());
        System.out.printf("Circle 3 Area: %.3f \n" , circle3.area());
        System.out.printf("Circle 3 Perimeter: %.3f \n" , circle3.perimeter());
        System.out.printf("Circle 3 Colour: " + circle3.colour());

        System.out.printf("Triangle 1 Area: %.3f \n" , triangle1.area());
        System.out.printf("Triangle 1 Perimeter: %.3f \n" , triangle1.perimeter());
        System.out.printf("Triangle 1 Colour: " + triangle1.colour());
        System.out.printf("Triangle 2 Area: %.3f \n" , triangle2.area());
        System.out.printf("Triangle 2 Perimeter: %.3f \n" , triangle2.perimeter());
        System.out.printf("Triangle 2 Colour: " + triangle2.colour());
        System.out.printf("Triangle 3 Area: %.3f \n" , triangle3.area());
        System.out.printf("Triangle 3 Perimeter: %.3f \n" , triangle3.perimeter());
        System.out.printf("Triangle 3 Colour: " + triangle3.colour());

        System.out.printf("Rectangle 1 Area: %.3f \n" , rectangle1.area());
        System.out.printf("Rectangle 1 Perimeter: %.3f \n" , rectangle1.perimeter());
        System.out.printf("Rectangle 1 Colour: " + rectangle1.colour());
        System.out.printf("Rectangle 2 Area: %.3f \n" , rectangle2.area());
        System.out.printf("Rectangle 2 Perimeter: %.3f \n" , rectangle2.perimeter());
        System.out.printf("Rectangle 2 Colour: " + rectangle2.colour());
        System.out.printf("Rectangle 3 Area: %.3f \n" , rectangle3.area());
        System.out.printf("Rectangle 3 Perimeter: %.3f \n" , rectangle3.perimeter());
        System.out.printf("Rectangle 3 Colour: " + rectangle3.colour());
        
        // System.out.printf("Circle 1 Perimeter: " + circle1.perimeter());
        // System.out.printf("Circle 1 Colour: " + circle1.colour());
        // System.out.printf("Circle 2 Area: " + circle2.area());
        // System.out.printf("Circle 2 Perimeter: " + circle2.perimeter());
        // System.out.printf("Circle 2 Colour: " + circle2.colour());
        // System.out.printf("Circle 3 Area: " + circle3.area());
        // System.out.printf("Circle 3 Perimeter: " + circle3.perimeter());
        // System.out.printf("Circle 3 Colour: " + circle3.colour());

        // System.out.printf("Triangle 1 Area: " + triangle1.area());
        // System.out.printf("Triangle 1 Perimeter: " + triangle1.perimeter());
        // System.out.printf("Triangle 1 Colour: " + triangle1.colour());
        // System.out.printf("Triangle 2 Area: " + triangle2.area());
        // System.out.printf("Triangle 2 Perimeter: " + triangle2.perimeter());
        // System.out.printf("Triangle 2 Colour: " + triangle2.colour());
        // System.out.printf("Triangle 3 Area: " + triangle3.area());
        // System.out.printf("Triangle 3 Perimeter: " + triangle3.perimeter());
        // System.out.printf("Triangle 3 Colour: " + triangle3.colour());

        // System.out.printf("Rectangle 1 Area: " + rectangle1.area());
        // System.out.printf("Rectangle 1 Perimeter: " + rectangle1.perimeter());
        // System.out.printf("Rectangle 1 Colour: " + rectangle1.colour());
        // System.out.printf("Rectangle 2 Area: " + rectangle2.area());
        // System.out.printf("Rectangle 2 Perimeter: " + rectangle2.perimeter());
        // System.out.printf("Rectangle 2 Colour: " + rectangle2.colour());
        // System.out.printf("Rectangle 3 Area: " + rectangle3.area());
        // System.out.printf("Rectangle 3 Perimeter: " + rectangle3.perimeter());
        // System.out.printf("Rectangle 3 Colour: " + rectangle3.colour());

        System.out.println(circle1.compareShape(circle2));
        System.out.println(circle1.compareShape(circle3));
        System.out.println(circle2.compareShape(circle3));

        System.out.println(triangle1.compareShape(triangle2));
        System.out.println(triangle1.compareShape(triangle3));
        System.out.println(triangle2.compareShape(triangle3));

        System.out.println(rectangle1.compareShape(rectangle2));
        System.out.println(rectangle1.compareShape(rectangle3));
        System.out.println(rectangle2.compareShape(rectangle3));
    }
}
