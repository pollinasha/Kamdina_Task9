public class Task2 {

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(4, 6);
        System.out.println("Площадь прямоугольника 4см*6см = " + rectangle.getArea());

        Square square = new Square(3);
        System.out.println("Площадь квадрата 3см*3см = " + square.getArea());

        Rhombus rhombus = new Rhombus(4, 3);
        System.out.println("Площадь ромба со стороной 4см и высотой 3см = " + rhombus.getArea());

        Circle circle = new Circle(2);
        System.out.println("Площадь круга с радиусом 2см = " + circle.getArea());
    }

}

class Circle implements Figure{
    // Радиус круга
    private final double r;

    public Circle(double r) {
        this.r = r;
    }

    @Override
    public double getArea() {
        return Math.PI * r * r;
    }
}

// В качестве корня иерархии всех фигур необходимо использовать заготовку интерфейса Figure
interface Figure {
    double getArea();
}

abstract class  Parallelogram implements Figure {
    private final double a;
    private final double b;


    public Parallelogram(double a, double b){
        this.a = a;
        this.b = b;

    }

    public double getArea() {
        return a * b;
    }

}

class Rectangle extends Parallelogram {

    public Rectangle(double a, double b) {
        super(a,b);
    }

}
class Rhombus extends Parallelogram {

    public Rhombus(double a, double h) {
        super(a,h);
    }


}
class Square extends Rectangle {

    public Square(double a) {
        super(a,a);
    }

}
