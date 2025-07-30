import java.util.Scanner;

public class TestTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Get user input
        System.out.println("Enter side1: ");
        double side1 = sc.nextDouble();
        System.out.println("Enter side2: ");
        double side2 = sc.nextDouble();
        System.out.println("Enter side3: ");
        double side3 = sc.nextDouble();

        System.out.println("Enter color: ");
        String color = sc.next();

        System.out.println("Is triangle filled (true/false)?");
        boolean filled = sc.nextBoolean();

        // Create Triangle object
        Triangle triangle = new Triangle(side1, side2, side3);
        triangle.setColor(color);
        triangle.setFilled(filled);

        // Display results
        System.out.println("\nTriangle Details:");
        System.out.println("Area: " + triangle.getArea());
        System.out.println("Perimeter: " + triangle.getPerimeter());
        System.out.println("Color: " + triangle.getColor());
        System.out.println("Date Created: " + triangle.getDateCreated());
        System.out.println("Filled: " + triangle.isFilled());
    }
}
