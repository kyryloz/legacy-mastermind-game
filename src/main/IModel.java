package main;

import java.util.*;

public interface IModel {
	void calculate(int[] input);
	int getBulls();
	int getCows();
	int getCount();
	
	void addObserver(Observer obs);
	void start();
	int numberAt(int i);
}
