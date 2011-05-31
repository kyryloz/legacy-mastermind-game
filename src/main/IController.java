package main;

import java.awt.event.MouseEvent;

public interface IController {
	void calculate(int[] input);

	void pressed(MouseEvent event);

	void released(MouseEvent event);

	void dragged(MouseEvent event);

	void isWin();

	void startAgain();
}
