package ch18;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JApplet;

@SuppressWarnings("serial")
public class Chapes extends JApplet {
	
	@Override
	public void init() {
		setSize(300,300);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(10));
		g.drawLine(10, 10, 200, 10);
		g.setColor(Color.yellow);
		g2.setStroke(new BasicStroke(10));
		g.drawRect(120, 40, 90, 55);
		
		g.setColor(Color.cyan);
		g.fillRect(120, 140, 90, 55);
		
		g.setColor(Color.red);
		g.fillRoundRect(120, 240, 90, 55, 30, 30);
		
		g.setColor(Color.blue);
		g.drawOval(10, 40, 90, 55);
		
		g.setColor(Color.pink);
		g.fillOval(10, 140, 90, 55);
		
		int[] x = {10,30,50,40,20};
		int[] y = {257,240,257,280,280};
		
		
		g.fillPolygon(x, y, x.length);
	}
	
	
}
