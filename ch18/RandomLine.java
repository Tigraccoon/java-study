package ch18;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JApplet;

@SuppressWarnings("serial")
public class RandomLine extends JApplet{
	private Random random;
	
	@Override
	public void init() {
		setSize(300,300);
		random = new Random();
	
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.clipRect(50, 100 , 200, 100);
		for(int i=0;i<100;i++) {
			int red = random.nextInt(256);
			int green = random.nextInt(256);
			int blue = random.nextInt(256);
			
			g.setColor(new Color(red,green,blue));
			
			int x1 = random.nextInt(300);
			int y1 = random.nextInt(300);
			int x2 = random.nextInt(300);
			int y2 = random.nextInt(300);
			
			g.drawLine(x1, y1, x2, y2);
			
		}
	}
	
}
