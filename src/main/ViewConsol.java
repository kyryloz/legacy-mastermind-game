package main;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

public class ViewConsol implements IView, Observer {
	IController controller;
	IModel model;
	
	public ViewConsol (IController controller, IModel model) {
		 this.controller = controller;
		 this.model = model;
		 model.addObserver(this);
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void startView() {
		// TODO Auto-generated method stub

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
