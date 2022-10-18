// Original Project 1 code by: Chris Baugh
// Utilization and Project 2 code by: Beckett Collins
// CSCI 3381
// Project 2

package project1base;

import java.io.File;
import java.util.ArrayList;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;


import javax.swing.JFrame;

public class P2MainTester 
{

	public static void main(String[] args) 
	{
		JFrame frame = new JFrame("Bootleg Netflix");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		NetflixPanel panel = new NetflixPanel();
		frame.getContentPane().add(panel);
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				panel.doClose();
			}
		});
	}

}
