package main;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class Circle {
	/**
	 * Класс цветного кружка
	 */
	private static final long serialVersionUID = 1L;
	private Ellipse2D.Double ellipse;
	private double defaultX;
	private double defaultY;
	private Color color = new Color(207, 207, 218);



	public Circle(int x, int y, int k, int l) {
		ellipse = new Ellipse2D.Double(x, y, k, l);
		defaultX = x;
		defaultY = y;
	}
	
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public void setX(double x) {
		ellipse.x = x;
	}
	public double getX() {
		return ellipse.x;
	}
	public void setY(double y) {
		ellipse.y = y;
	}
	public double getY() {
		return ellipse.y;
	}
	public Shape getShape() {
		// TODO Auto-generated method stub
		return ellipse;
	}
	public void setDefaultXY() {
		ellipse.x = defaultX;
		ellipse.y = defaultY;

	}
	public void hide() {
		ellipse.height = 0;
		ellipse.width = 0;
	}
	public void show() {
		ellipse.height = 28;
		ellipse.width = 28;
	}
}
