package shapes;

import Commands.ColorCommand.Color;

public class Shape {
	private int idNumber;
	private Color color;
	private int[] origin;
	
	public int getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public int[] getOrigin() {
		return origin;
	}
	public void setOrigin(int[] origin) {
		this.origin = origin;
	}
	public int getX() {
		return origin[0];
	}
	public void setX(int x) {
		origin[0] = x;
	}
	public int getY() {
		return origin[1];
	}
	public void setY(int y) {
		origin[1] = y;
	}
}
