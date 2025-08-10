public class TestColorable {
    public static void main(String[] args) {
        GeometricObject[] objects = new GeometricObject[5];

        objects[0] = new Triangle(3, 4, 5, "red", true);
        objects[1] = new Triangle(5, 5, 5, "blue", false);
        objects[2] = new Triangle(2, 3, 4, "green", true);
        objects[3] = new Triangle(6, 6, 6, "yellow", true);
        objects[4] = new Triangle(7, 8, 9, "black", false);

        for (GeometricObject obj : objects) {
            System.out.printf("Area: %.4f%n", obj.getArea());
            if (obj instanceof Colorable) {
                ((Colorable) obj).howToColor();
            }
            System.out.println();
        }
    }
}
