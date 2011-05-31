package main;

import java.awt.Color;
import java.awt.event.MouseEvent;

public class Controller implements IController {
	private ViewFactory factory = new ViewFactory();
	private IModel model;
	private IView view;
	
	private int currentAttempt = 0;
	private int[] maskSelection = {0, 0, 0, 0};

	
	
	public Controller(IModel model, String viewType) {
		this.model = model;
		view = factory.getView(viewType, this, model);
		view.startView();
		
		int count = model.getCount();
		
		//закрасить белым первые 4 гнезда
		for (int i = 0; i < 4; i++) {
			for (int j = count; j < count+1; j++) {
				view.paintOverCircle(i, j, Color.white);
			}
		}
	}

	
	@Override
	public void calculate(int[] input) {
		model.calculate(input);
		
		int count = model.getCount();
		
		//закрасить белым следующие 4 гнезда
		for (int i = 0; i < 4; i++) {
			for (int j = count; j < count+1; j++) {
				view.paintOverCircle(i, j, Color.white);
			}
		}
	}
	
	
	public void dragged(MouseEvent event) {
		if (view.getChooseCircleMenu() != null) {
			view.getChooseCircleMenu().setX(event.getX()-14);
			view.getChooseCircleMenu().setY(event.getY()-14);
			view.repaint();

		}
		
	}
	public void pressed(MouseEvent event) {
		for (int i = 0; i < 10; i++) {
			Circle pressedColor = view.getCircleMenu(i);
			if (pressedColor.getShape().contains(event.getX(), event.getY())) {
				view.setChooseCircleMenu(view.getCircleMenu(i));
			}
		}
	}
	public void released(MouseEvent event) {
		if (view.getChooseCircleMenu() != null) {
			int count = model.getCount();
			
			for (int i = 0; i < 4; i++) {
				for (int j = count; j < count+1; j++) {
					Circle releasedCircle = view.getCircleInput(i, j);
					if (releasedCircle.getShape().contains(event.getX(), event.getY())) {
						if (maskSelection[i] == 0) {
							view.getChooseCircleMenu().hide();
							view.paintOverCircle(i, j, view.getChooseCircleMenu().getColor());
							Color color = view.getChooseCircleMenu().getColor();
							view.addResult(i, ANumbersColors.getNumberByColor(color)); 						
							view.repaint();
							
							currentAttempt++;	
							maskSelection[i] = 1;
						}
					} else {
						view.getChooseCircleMenu().setDefaultXY();
						view.repaint();
					}
				}
				
			}
			view.setChooseCircleMenu(null);
			
			if (currentAttempt>3) {
				calculate(view.getResultInput());
				currentAttempt = 0;
				for (int i = 0; i < 10; i++) {
					view.getCircleMenu(i).setDefaultXY();
					view.getCircleMenu(i).show();
					view.repaint();
					
				}
				for (int i = 0; i < 4; i++)
					maskSelection[i] = 0;
			}
		}
	}


	@Override
	public void isWin() {
		if (model.getBulls() == 4) {
			showCode();
			view.showWin();	
			startAgain();
			hideCode();
			
			
		} else if (model.getCount() == 10) {
			showCode();
			view.showFail();
			startAgain();
			hideCode();
		}
		
	}
	private void showCode() {
		for (int i = 0; i < 4; i++) {
			Color color = ANumbersColors.getColorByNumber(model.numberAt(i));
			view.paintOverCircle(i, color);
			view.getCircleResult(i).show();
			view.repaint();
		}
	}
	private void hideCode() {
		for (int i = 0; i < 4; i++) {
			view.getCircleResult(i).hide();
			view.repaint();
		}
	}


	@Override
	public void startAgain() {
		model.start();
		view.eraseWindows();
		currentAttempt = 0;
		for (int i = 0; i < 10; i++) {
			view.getCircleMenu(i).setDefaultXY();
			view.getCircleMenu(i).show();
			view.repaint();
			
		}
		for (int i = 0; i < 4; i++)
			maskSelection[i] = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 10; j++) {
				view.paintOverCircle(i, j, new Color(207, 207, 218));
			}
		}
		int count = model.getCount();
		for (int i = 0; i < 4; i++) {
			for (int j = count; j < count+1; j++) {
				view.paintOverCircle(i, j, Color.white);
			}
		}
	}
	
}
