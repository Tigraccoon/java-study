package ch17;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class AppletExam extends Applet {
	
	@Override
	public void init() {
		System.out.println("init!");
	}
	
	@Override
	public void start() {
		System.out.println("Start!");
	}
	
	@Override
	public void paint(Graphics g) {
		System.out.println("Paint!");
		g.setColor(Color.GREEN);
		g.fillRect(10, 10, 50, 50);
	}
	
	@Override
	public void stop() {
		System.out.println("Stop!");
	}
	
	@Override
	public void destroy() {
		System.out.println("DESTROY!");
	}
	
}
