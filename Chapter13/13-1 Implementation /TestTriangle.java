import java.util.Scanner;

public class TestTriangle {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter side1: ");
            double side1 = sc.nextDouble();

            System.out.print("Enter side2: ");
            double side2 = sc.nextDouble();

            System.out.print("Enter side3: ");
            double side3 = sc.nextDouble();

            System.out.print("Enter color: ");
            String color = sc.next();

            System.out.print("Is filled (true/false): ");
            boolean filled = sc.nextBoolean();

            Triangle t = new Triangle(side1, side2, side3, color, filled);

            System.out.printf("Area: %.4f%n", t.getArea());
            System.out.printf("Perimeter: %.4f%n", t.getPerimeter());
            System.out.println("Color: " + t.getColor());
            System.out.println("Filled: " + t.isFilled());
        }
    }
}
