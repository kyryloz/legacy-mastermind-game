package main;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import layout.TableLayout;

public class NumbersGUI implements IView, Observer {
	private IController controller;
	private IModel model;
	
	private JPanel mainPanel;
	private JTextField[][] inputField;
	private JTextField[][] result;
	
	public NumbersGUI (IController controller, IModel model) {
		 this.controller = controller;
		 this.model = model;
		 model.addObserver(this);
	}

	
	@Override
	public void startView() {
		JFrame frame = new JFrame();
		frame.setSize(360, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle("MasterMind");
		frame.setLocation(200,100);
		
		mainPanel = new JPanel();
		mainPanel.setBackground(Color.LIGHT_GRAY);
		
		double size[][] =
        {{30, 30, 30, 30, 30, 30, 30, 50, 30, 30, 30, 10},
         {40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 20}};

		mainPanel.setLayout(new TableLayout(size));
		
		ActionListener listener = new ButtonListener();
		
		JButton[] button = new JButton[10];
		for (int i = 0; i < 10; i++) {
			button[i] = new JButton("\u2192");
			mainPanel.add(button[i], 7+" "+(10-i));
			button[i].addActionListener(listener);
		}
		
		
		

		
		JLabel[] label = new JLabel[10];
		for (int i = 0; i < 10; i++) {
			label[i] = new JLabel(""+(i+1));
			Font font = new Font("Dialog",Font.PLAIN, 20);
			label[i].setFont(font);
			mainPanel.add(label[i], 1+" "+(10-i));
		}
		/*
		InputColorPanel[][] inputColor = new InputColorPanel[4][10];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 10; j++) {
				inputColor[i][j] = new InputColorPanel();
				//inputColor[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
				mainPanel.add(inputColor[i][j], (2+i)+" "+(10-j));
			}
		}*/
		
		
		
		
		inputField = new JTextField[4][10];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 10; j++) {
				inputField[i][j] = new JTextField();
				inputField[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
				Font font = new Font("Dialog",Font.PLAIN, 30);
				inputField[i][j].setFont(font);
				mainPanel.add(inputField[i][j], (2+i)+" "+(10-j));
			}
		}
		
		result = new JTextField[2][10];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 10; j++) {
				result[i][j] = new JTextField();
				result[i][j].setEnabled(false);
				Font font = new Font("Dialog",Font.PLAIN, 30);
				result[i][j].setFont(font);
				mainPanel.add(result[i][j], (8+i)+" "+(10-j));
			}
		}
		
		frame.add(mainPanel);
		
		frame.setVisible(true);
	}
	
	private int[] getInput() {
		int k = model.getCount();
		int[] input = new int[4];
		for (int i = 0; i < 4; i++) {
			input[i] = Integer.parseInt(inputField[i][k].getText());
		}
		return input;
	} 

	@Override
	public void update(Observable o, Object arg) {
		int k = model.getCount();
		result[0][k-1].setText(""+model.getBulls());
		result[1][k-1].setText(""+model.getCows());
	}
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			controller.calculate(getInput());
		}
	}
	@Override
	public void repaint() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Circle getChooseCircleMenu() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Circle getCircleInput(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Circle getCircleMenu(int i) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void setChooseCircleMenu(Circle circleMenu) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void paintOverCircle(int i, int j, Color color) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void addResult(int i, int numberByColor) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public int[] getResultInput() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void showWin() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void showFail() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void eraseWindows() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void paintOverCircle(int i, Color color) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Circle getCircleResult(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
