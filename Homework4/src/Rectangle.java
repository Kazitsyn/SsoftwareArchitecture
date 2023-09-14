public class Rectangle implements IShape{
    private double a;
    private double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public Rectangle(double a) {
        this.a = a;
        this.b = a;
    }

    /**
     * Площадь фигуры
     *
     * @return
     */
    @Override
    public double getArea() {
        return a*b;
    }

    /**
     * Периметр фигуры
     *
     * @return
     */
    @Override
    public double getPerimeter() {
        return 2*(a+b);
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "прямоугольник {" +
                "a = " + a +
                ", b = " + b +
                '}';
    }
}
