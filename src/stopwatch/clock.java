package stopwatch;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.TimerTask;
import java.util.Timer;

import javax.swing.*;


public class clock extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	JButton startbtn,stopbtn;
	JLabel hrs,mins, secs,hrsl,minsl, secsl;
//	Shape circle = new Ellipse2D.Float(100.0f,100.0f,100.0f,100.0f);
	 Timer timer;
	 Toolkit toolkit;
//	 public void paint(Graphics g) {
//		 Graphics2D ga = (Graphics2D)g;
//		 ga.draw(circle);
//		 ga.setPaint(Color.black);
//		 ga.fill(circle);
//	 }
	public clock(){
		
		
		 hrs = new JLabel("00");
		 mins= new JLabel("00");
		 secs = new JLabel("00");
			
		 hrsl = new JLabel("hrs");
		 minsl = new JLabel("min");
		 secsl = new JLabel("secs");
		 startbtn = new JButton("Start");
		 stopbtn = new JButton("Stop");
		

		
		hrs.setBounds(150,80,50,30);
		mins.setBounds(250,80,50,30);
		secs.setBounds(350,80,50,30);
		hrsl.setBounds(150,50,50,30);
		minsl.setBounds(250,50,50,30);
		secsl.setBounds(350,50,50,30);
		
		startbtn.setBounds(150,400,100,50);
		stopbtn.setBounds(320,400,100,50);
		
		add(hrs);
		add(secs);
		add(mins);
		add(hrsl);
		add(secsl);
		add(minsl);
		
		startbtn.addActionListener(this);
		stopbtn.addActionListener(this);
		add(startbtn);
		add(stopbtn);
		setSize(600,600);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		stopbtn.setEnabled(false);
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == startbtn) {
			System.out.println("countdown started");
			toolkit =Toolkit.getDefaultToolkit();
			timer = new Timer();
			timer.schedule(new count(),0,1 * 1000);
		startbtn.setEnabled(false);
		stopbtn.setEnabled(true);
		}
		if(e.getSource() == stopbtn) {
			timer.cancel();
			startbtn.setEnabled(true);
			stopbtn.setEnabled(false);
		}
		
	}
	public static void main(String [] args) {
		new clock();
	}
	
	

 class count extends TimerTask{
	 int numwarning = 60;
	 int sec = 0;
		int hr = 0;
		int min = 0;
		
	
	public void run() {
		if(numwarning > 0) {
			
			sec++;
			secs.setText(Integer.toString(sec));
			System.out.println(secs);
			numwarning--;
			if(numwarning == 0) {
				System.out.println("restarting");
				numwarning = 60;
				sec = 0;
				secs.setText(Integer.toString(sec));
				min++;
				toolkit.beep();
				mins.setText(Integer.toString(min));
				System.out.println("minutes down " + min);
				if(min == 60) {
					min = 0;
					mins.setText(Integer.toString(min));
					hr++;
					hrs.setText(Integer.toString(hr));
					System.out.println("hrs down "+ hr);
				}
			}
		}else {
			System.out.println("Times up");
			System.exit(0);
		}

	}

 }
	
}
