public class TestOctagon {
    public static void main(String[] args) {
        Octagon o1 = new Octagon(5.0, "blue", true);

        // clone the first octagon
        Octagon o2 = (Octagon) o1.clone();

        System.out.printf("o1 - side: %.2f, area: %.6f, perimeter: %.2f%n",
                o1.getSide(), o1.getArea(), o1.getPerimeter());
        System.out.printf("o2 - side: %.2f, area: %.6f, perimeter: %.2f%n",
                o2.getSide(), o2.getArea(), o2.getPerimeter());

        // compare the two objects
        int cmp = o1.compareTo(o2);
        String relation = (cmp == 0) ? "equal to" : (cmp < 0 ? "smaller than" : "greater than");
        System.out.println("o1 is " + relation + " o2");
    }
}
