public class Triangle implements IShape{
    private double a;
    private  double b;
    private  double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }




    /**
     * Площадь фигуры
     *
     * @return
     */
    @Override
    public double getArea() {
        double p = getPerimeter()/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }

    /**
     * Периметр фигуры
     *
     * @return
     */
    @Override
    public double getPerimeter() {
        return a+b+c;
    }

    @Override
    public String toString() {
        return "треугольник {" +
                "a = " + a +
                ", b = " + b +
                ", c = " + c +
                '}';
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setC(double c) {
        this.c = c;
    }
}
