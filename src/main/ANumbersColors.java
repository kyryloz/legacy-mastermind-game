package main;

import java.awt.Color;

public abstract class ANumbersColors {
	public static Color getColorByNumber(int i) {
		Color c = Color.white;
		switch (i) {
			case 0: c = Color.blue;     break;
			case 1: c = Color.cyan;     break;
			case 2: c = Color.green;    break;
			case 3: c = Color.magenta;  break;
			case 4: c = Color.orange;   break;
			case 5: c = Color.pink;     break;
			case 6: c = Color.red;      break;
			case 7: c = Color.yellow;   break;
			case 8: c = Color.darkGray; break;
			case 9: c = Color.GRAY;     break;
		}
		return c;		
	}
	
	public static int getNumberByColor(Color color) {
		int n = 0;
		if (color == Color.blue)
			n = 0;
		if (color == Color.cyan)
			n = 1;
		if (color == Color.green)
			n = 2;
		if (color == Color.magenta)
			n = 3;
		if (color == Color.orange)
			n = 4;
		if (color == Color.pink)
			n = 5;
		if (color == Color.red)
			n = 6;
		if (color == Color.yellow)
			n = 7;
		if (color == Color.darkGray)
			n = 8;
		if (color == Color.GRAY)
			n = 9;
		return n;	
	}
}
