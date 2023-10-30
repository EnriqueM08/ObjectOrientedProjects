package shapes;

import Commands.ColorCommand.Color;

public class Rectangle extends Shape{
	private int width;
	private int height;

	public Rectangle(int width, int height) {
		this.setWidth(width);
		this.setHeight(height);
		setColor(Color.Red);
		setOrigin(new int[] {0, 0});
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public String toString() {
		return "Rectangle, Color: " + getColor() + ", Origin: (" + getX() + "," + getY() + "), Width: " + width + ", Height: " + height;
	}

}
