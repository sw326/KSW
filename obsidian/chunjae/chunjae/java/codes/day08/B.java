class Figure
{
	void draw(){
		System.out.println("draw the figure");
	}
}
class Circle extends Figure
{
	void draw(){ // overriding
		System.out.println("draw the Circle");
	}
}
class Rect extends Figure
{
	void draw(){
		System.out.println("draw the Rectagle");
	}
}
class Triangle extends Figure
{
	void draw(){
		System.out.println("draw the Triangle");
	}
}
class B 
{
	public static void main(String[] args) 
	{
		Figure f1 = new Figure();
		Figure f2 = new Circle();
		Figure f3 = new Rect();
		Figure f4 = new Triangle();
		f1.draw();f2.draw();f3.draw();f4.draw();
	}
}
