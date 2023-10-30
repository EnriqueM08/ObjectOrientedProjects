package shapes;

import Commands.ColorCommand.Color;

public class Circle extends Shape{
	private int radius; 
	
	public Circle(int radius) {
		this.radius = radius;
		setColor(Color.Blue);
		setOrigin(new int[] {0, 0});
	}
	
	public String toString() {
		return "Circle, Color: " + getColor() + ", Origin: (" + getX() + "," 
	            + getY() + "), Radius: " + radius;
	}
}
