package edu.pragmatic07;

/**
 * Tozi klas e za pravoygylnici
 * @author Plamen
 *
 */
public class Rectangle {

	private double width;
	private double height;
	
	public Rectangle(double width, double height) {
		super();
		this.width = width;
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	public double calculateArea() {
		return width * height;
	}
	
	@Override
	public String toString() {
		return "Rectangle: w = " + width + ", h = " + height;
	}
	
}
