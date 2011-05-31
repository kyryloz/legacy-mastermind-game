package main;

import java.awt.Color;

public interface IView {
	void startView();

	void repaint();

	Circle getChooseCircleMenu();

	Circle getCircleInput(int i, int j);

	Circle getCircleMenu(int i);

	void setChooseCircleMenu(Circle circleMenu);

	void paintOverCircle(int i, int j, Color color);

	void addResult(int i, int numberByColor);

	int[] getResultInput();

	void showWin();

	void showFail();

	void eraseWindows();

	void paintOverCircle(int i, Color color);

	Circle getCircleResult(int i);
}
