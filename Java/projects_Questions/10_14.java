import static java.lang.Math.PI;
import static java.lang.Math.sqrt;
class Shape{
	private String name, description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public Shape(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	@Override
	public String toString() {
		return String.format("The name of the Shape is: %s%nDiscription: %s", getName(), getDescription());
		
	}
	
}

abstract class TwoDimensinalShape extends Shape{
	
	public TwoDimensinalShape(String name, String description) {
		super(name, description);
	}

	public abstract double area();
}
abstract class ThreeDimensinalShape extends Shape{
	
	public ThreeDimensinalShape(String name, String description) {
		super(name, description);
	}

	public abstract double area();
	public abstract double volume();
}
class Circle extends TwoDimensinalShape{
	private double radius;
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public Circle (String name, String description, double radius) {
		super(name, description);
		this.radius = radius;
	}
	
	@Override
	public double area() {
		return (getRadius() * getRadius() ) * PI;
		
	}
	
	@Override
	public String toString() {
		return String.format("%s%nArea: %.2f", super.toString(), area());
	}
	
}
class Square extends TwoDimensinalShape{
	private double side;
	public double getSide() {
		return side;
	}
	public void setSide(double side) {
		this.side = side;
	}
	
	public Square(String name, String description, double side) {
		super(name, description);
		this.side = side;
	}
	
	@Override
	public double area() {
		return getSide() * getSide();
		
	}
	
	@Override
	public String toString() {
		return String.format("%s%nArea: %.2f", super.toString(), area());
	}
	
}
class Triangle extends TwoDimensinalShape{
	private double height, base;
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getBase() {
		return base;
	}
	public void setBase(double base) {
		this.base = base;
	}
	
	public Triangle(String name, String description, double height, double base) {
		super(name, description);
		this.height = height;
		this.base = base;
	}
	
	@Override
	public double area() {
		return (getHeight() * getBase()) / 2;
		
	}
	
	@Override
	public String toString() {
		return String.format("%s%nArea: %.2f", super.toString(), area());
	}
	
}
class Sphere extends ThreeDimensinalShape{
	private double radius;
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public Sphere (String name, String description, double radius) {
		super(name, description);
		this.radius = radius;
	}
	
	@Override
	public double area() {
		return (getRadius() * getRadius() ) * PI * 4;
		
	}
	
	@Override
	public double volume() {
		return ((getRadius() * getRadius() * getRadius() ) * PI) * (4/3);
	}
	
	@Override
	public String toString() {
		return String.format("%s%nArea: %.2f%nVolume: %.2f", super.toString(), area(), volume());
	}
	
}
class Cube extends ThreeDimensinalShape{
	private double side;
	public double getSide() {
		return side;
	}
	public void setSide(double side) {
		this.side = side;
	}
	
	public Cube (String name, String description, double side) {
		super(name, description);
		this.side = side;
	}
	
	@Override
	public double area() {
		return  6 * (getSide() * getSide());
		
	}
	
	@Override
	public double volume() {
		return getSide() * getSide() * getSide();
	}
	
	
	@Override
	public String toString() {
		return String.format("%s%nArea: %.2f%nVolume: %.2f", super.toString(), area(), volume());
	}
}
class Tetrahedron extends ThreeDimensinalShape{
	private double edge;
	public double getEdge() {
		return edge;
	}
	public void setEdge(double edge) {
		this.edge = edge;
	}
	
	public Tetrahedron(String name, String description, double edge) {
		super(name, description);
		this.edge = edge;
	}
	
	@Override
	public double area() {
		return (getEdge() * getEdge() )  * (sqrt(3));
		
	}
	
	@Override
	public double volume() {
		return (getEdge() * getEdge() * getEdge()) / (6 * (sqrt(2)));
	}
	
	@Override
	public String toString() {
		return String.format("%s%nArea: %.2f%nVolume: %.2f", super.toString(), area(), volume());
	}
}
public class Test {
	public static void main(String[] args) {
		Shape[] shape = { new Circle("Circle", "2d circle", 3),
			new Square("square", "2d square", 4),
			new Triangle("Triangle", "2d Triangle", 4, 3),
			new Sphere("Sphere", "3d circle", 3),
			new Cube ("Cube", "3d square", 4),
			new Tetrahedron("Tetrahedron", "3d Triangle", 7)
		};
//		for (Shape currentShape : shape) {
//			if (currentShape instanceof TwoDimensinalShape) {
//				System.out.printf("area: %.2f%n",((TwoDimensinalShape) currentShape).area());
//			}else
//				System.out.printf("area: %.2f%nvolume: %.2f%n%n", ((ThreeDimensinalShape) currentShape).area(), ((ThreeDimensinalShape) currentShape).volume());
//		}
		
		for (Shape currentShape : shape) {
			System.out.println(currentShape);
		}
	}
}