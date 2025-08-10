public class Octagon extends GeometricObject
        implements Comparable<Octagon>, Cloneable {

    private double side = 1.0;

    public Octagon() { }

    public Octagon(double side) {
        this.side = side;
    }

    public Octagon(double side, String color, boolean filled) {
        super(color, filled);
        this.side = side;
    }

    public double getSide() { return side; }
    public void setSide(double s) { side = s; }

    @Override
    public double getPerimeter() {
        return 8 * side;
    }

    @Override
    public double getArea() {
        // Regular octagon area: 2 * (1 + sqrt(2)) * side^2
        return 2 * (1 + Math.sqrt(2)) * side * side;
    }

    @Override
    public int compareTo(Octagon o) {
        double a1 = this.getArea();
        double a2 = o.getArea();
        return Double.compare(a1, a2);
    }

    @Override
    public Object clone() {
        try {
            return super.clone(); // fields are primitives; shallow clone is fine
        } catch (CloneNotSupportedException e) {
            // Shouldn't happen because we implement Cloneable
            throw new AssertionError(e);
        }
    }
}
