public class Main {
    public static void main(String[] args) {
        GeometryFigure figureBox = new GeometryFigure();
        Circle circle1 = new Circle(10);
        figureBox.add(circle1);

        Rectangle rectangle1 = new Rectangle(15);
        Rectangle rectangle2 = new Rectangle(15, 3);

        figureBox.add(rectangle1);
        figureBox.add(rectangle2);

        Triangle triangle1 = new Triangle(3,4,5);
        triangle1.setA(1);
        figureBox.add(triangle1);

        IShape triangle2 = new Triangle(5,4,3);
        figureBox.add(triangle2);



        figureBox.getInfo(figureBox.indexOfFigure(circle1));
        figureBox.getInfo(figureBox.indexOfFigure(rectangle1));
        figureBox.getInfo(figureBox.indexOfFigure(rectangle2));
        figureBox.getInfo(figureBox.indexOfFigure(triangle1));
        figureBox.getInfo(figureBox.indexOfFigure(triangle2));



    }
}