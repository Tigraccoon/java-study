package ch18;

import java.applet.AudioClip;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Sound extends JApplet implements ActionListener {
	
	private AudioClip audio;
	private JButton play, stop, loop;
	
	@Override
	public void init() {
		setLayout(new FlowLayout());
		audio = getAudioClip(getClass().getResource("dingdong.wav"));
		
		play = new JButton("Play");
		stop = new JButton("Stop");
		loop = new JButton("Loop");
		
		add(play);
		add(stop);
		add(loop);
		
		//버튼 클릭 이벤트 기능 추가
		play.addActionListener(this);
		stop.addActionListener(this);
		loop.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//getSource() : Object타입이므로 형 변환이 필요
		JButton btn = (JButton)e.getSource();
		System.out.println(e.getSource());
		if(btn == play) {
			audio.play();
		}else if (btn == stop) {
			audio.stop();
		}else if (btn == loop) {
			audio.loop();
		}
		
		
	}

}
