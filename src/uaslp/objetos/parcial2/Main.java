package uaslp.objetos.parcial2;

import java.lang.reflect.Modifier;
import java.util.LinkedList;
import java.util.List;

abstract class Figure{
   private static int figuresCreated;
   private final String name;

   protected Figure(String name){
       this.name=name;

       figuresCreated++;
   }
   public abstract float getArea();
   public abstract float getPerimeter();

   public final String getName(){
       return name;
   }

   public static int getFiguresCreated(){
       return figuresCreated;
   }

}

class Circle extends Figure{
   private float radio;


    public Circle(){
       super("Circulo");  //solamente se puede llamar como la primer instruccion en el constructor de la clase hija
   }

    public Circle(float radio){
        super("Circulo");
        this.radio=radio;
    }

   public float getArea (){
       return (float)(Math.PI * radio * radio);
    }

   public float getPerimeter(){
       return (float)(Math.PI * radio * 2);
   }

    public float getRadio() {
        return radio;
    }

    public void setRadio(float radio) {
        this.radio = radio;
    }
}

class Rectangle extends Figure{
    private float base;
    private float height;

    public Rectangle(){
        super("Rectángulo");
    }

    public Rectangle(float base, float height){
        super("Rectángulo");

        this.base=base;
        this.height=height;
    }

    public float getArea (){
        return base * height;
    }
    public float getPerimeter(){
        return 2*base + 2*height;
    }

    public float getBase() {
        return base;
    }

    public void setBase(float base) {
        this.base = base;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
}

class Polygon extends Figure{
    private float apotema;
    private int sidesCount;
    private float sideLength;

    public Polygon(float apotema, int sidesCount, float sideLength){
        super("Polígono");

        this.apotema=apotema;
        this.sideLength=sideLength;
        this.sidesCount=sidesCount;
    }

    public float getArea (){
        return getPerimeter() * apotema/2;
    }
    public float getPerimeter(){
        return sidesCount*sideLength;
    }
}

public class Main {

    public static void main(String[] args) {
        //Figure figure = new Figure();
        List<Figure> figureList = new LinkedList<>();

        /*circlesTest();
        rectanglesTest();
        polygonTest();*/
        figureList.add(new Polygon(4,5,6.3f));
        figureList.add(new Polygon(4.5f,8, 3.9f));

        figureList.add(new Rectangle(4,5));
        figureList.add(new Rectangle(4.5f,9.6f));

        Circle circle1 = new Circle();
        Circle circle2 = new Circle(10.6f);

        circle1.setRadio(5.3f);

        figureList.add(circle1);
        figureList.add(circle2);

        //POLIMORFISMO
        for(Figure figure: figureList){
            System.out.println(figure.getName() + ", Area: " + figure.getArea() + ", Perímtetro: " + figure.getPerimeter());
        }

        if(Modifier.isAbstract(Figure.class.getModifiers())){
            System.out.println("Figure es abstracta");
        }

        System.out.println("Se generaron: " + Figure.getFiguresCreated() + " figuras");
    }

    private static void polygonTest() {
        List<Polygon> plygonList = new LinkedList<>();

        plygonList.add(new Polygon(4,5,6.3f));
        plygonList.add(new Polygon(4.5f,8, 3.9f));

        for(Polygon polygon: plygonList){
            System.out.println(polygon.getName() + ", Area: " + polygon.getArea() + ", Perímtetro: " + polygon.getPerimeter());
        }
    }

    private static void rectanglesTest() {
        List<Rectangle> rectangleList = new LinkedList<>();

        rectangleList.add(new Rectangle(4,5));
        rectangleList.add(new Rectangle(4.5f,9.6f));

        for(Rectangle rectangle: rectangleList){
            System.out.println(rectangle.getName() + ", Area: " + rectangle.getArea() + ", Perímtetro: " + rectangle.getPerimeter());
        }
    }

    private static void circlesTest() {
        List<Circle> circleList = new LinkedList<>();
        Circle circle1 = new Circle();
        Circle circle2 = new Circle(10.6f);

        circle1.setRadio(5.3f);

        circleList.add(circle1);
        circleList.add(circle2);

        for(Circle circle: circleList){
            System.out.println(circle.getName() + ", Area: " + circle.getArea() + ", Perímtetro: " + circle.getPerimeter());
        }
    }
}