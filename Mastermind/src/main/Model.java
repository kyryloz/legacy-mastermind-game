package main;

import java.util.*;

public class Model extends Observable implements IModel {
	private List<Integer> set;
	private int bulls;
	private int cows;
	private int count;
	
	public Model() {
		start();
		count = 0;
	}


	@Override
	public void calculate(int[] input) {
		for(int i = 0; i < 4; i++) {
			if (set.contains(input[i])) {
				cows++;
			}
			if (input[i] == numberAt(i)) {
				bulls++;
				cows--;
			}
		}
		count++;
		setChanged();
		notifyObservers();
		eraseResult();
	}
	public int getBulls() {
		return bulls;
	}
	public int getCows() {
		return cows;
	}
	public int getCount() {
		return count;
	}
	
	public int numberAt(int index) {
		return set.get(index);
	}
	
	private void fillSet(List<Integer> s) {
		while (s.size()<4) {
			int x = new Random().nextInt(10);
			if (!s.contains(x)) {
				s.add(x);
			}
		}
	}
	
	private void eraseResult() {
		bulls = 0;
		cows = 0;
	}

	
	public void start() {
		set = new ArrayList<Integer>();
		fillSet(set);
		count = 0;
	}

}
