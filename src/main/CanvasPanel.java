package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;



import javax.swing.JPanel;

public class CanvasPanel extends JPanel {
	/**
	 * На этой панели отрисовывается вся графика
	 */
	private static final long serialVersionUID = 1L;
   

	private Circle[][] circleInput;
	private Circle[] circleMenu;
	private Circle[] circleResult;

	public CanvasPanel() {
		circleInput = new Circle[4][10];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 10; j++) {
				circleInput[i][j] = new Circle(92+i*30, 428-j*40, 28, 28);
			}
		}
		circleMenu = new Circle[10];
		for (int i = 0; i < 10; i++) {
			circleMenu[i] = new Circle(30+i*30, 490, 28, 28);
			circleMenu[i].setColor(ANumbersColors.getColorByNumber(i));
		}
		circleResult = new Circle[4];
		for (int i = 0; i < 4; i++) {	
			circleResult[i] = new Circle(92+i*30, 17, 0, 0);
		}
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(Color.LIGHT_GRAY);
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(new Color(146, 146, 169));
		g2.fillRoundRect(85, 62, 132, 400, 10, 10);
		g2.fillRoundRect(24, 484, 310, 40, 10, 10);
		g2.fillRoundRect(85, 14, 132, 34, 10, 10);
		g2.setColor(Color.black);
		g2.drawRoundRect(85, 62, 132, 400, 10, 10);
		g2.drawRoundRect(24, 484, 310, 40, 10, 10);
		g2.drawRoundRect(85, 14, 132, 34, 10, 10);
		
		//create input
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 10; j++) {
				g2.setColor(circleInput[i][j].getColor());
				g2.fill(circleInput[i][j].getShape());
		        g2.draw(circleInput[i][j].getShape());
		        g2.setColor(Color.black);
		        g2.draw(circleInput[i][j].getShape());
			}
		}
		
		//create menu
		for (int i = 0; i < 10; i++) {
			g2.setColor(circleMenu[i].getColor());
			g2.fill(circleMenu[i].getShape());
		    g2.draw(circleMenu[i].getShape());
		    g2.setColor(Color.black);
		    g2.draw(circleMenu[i].getShape());
		}
		
		//create result at top		
		for (int i = 0; i < 4; i++) {	
			g2.setColor(circleResult[i].getColor());
			g2.fill(circleResult[i].getShape());
		    g2.draw(circleResult[i].getShape());
		    g2.setColor(Color.black);
		    g2.draw(circleResult[i].getShape());
		}
		
	}

	public void paintOverInputCircle(int i, int j, Color color) {
		circleInput[i][j].setColor(color);
		repaint();
	}
	public void paintOverResultCircle(int i, Color color) {
		circleResult[i].setColor(color);
		repaint();
	}
	
	public Circle getCircleMenu(int i) {
		return circleMenu[i];
	}
	public Circle getCircleInput(int i, int j) {
		return circleInput[i][j];
	}
	public Circle getCircleResult(int i) {
		return circleResult[i];
	}
}
