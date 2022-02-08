package Coding_Exam_A;

import java.awt.Color;
import java.awt.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class CodingExamA {

	public static void main(String[] args) {

		/*
		 * Write a program that asks the user for three pieces of information. 1. How
		 * many robots 2. The color of the shapes 3. How many sides each shape will have
		 * 
		 * Once the information has been collected, the program will then make the
		 * requested number of robots each draw the requested shape in the requested
		 * color. The robots should execute at the same time so Threads will need to be
		 * used. Arrange the robots so that the shapes do not overlap. For full credit,
		 * define the Thread functions using lambdas.
		 * 
		 * See the Coding_Exam_A_Demo.jar for an example of what the finished product
		 * should look like.
		 */

		String s = JOptionPane.showInputDialog("How many Robots?");
		String s2 = JOptionPane.showInputDialog("What Color?(Red,Green,Blue)");
		String s3 = JOptionPane.showInputDialog("How many sides?");
		int input = Integer.parseInt(s);
		int sides = Integer.parseInt(s3);
		Thread[] t = new Thread[input];
		for (int i = 0; i < input; i++) {
			int counter = (i * 100) + 100;
			t[i] = new Thread(() -> {
				Robot r = new Robot();
				r.moveTo(counter, 250);
				r.setPenWidth(3);
				r.penDown();
				r.setSpeed(1);
				r.hide();
				if (s2.equalsIgnoreCase("red")) {
					r.setPenColor(Color.red);
				} else if (s2.equalsIgnoreCase("green")) {
					r.setPenColor(Color.green);
				} else if (s2.equalsIgnoreCase("blue")) {
					r.setPenColor(Color.blue);
				}
				for (int j = 0; j < sides; j++) {
					try {
						r.microMove(10);
						r.microTurn(33);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}
		for (int i = 0; i < t.length; i++) {
			t[i].start();
			System.out.println("test");
		}
	}
}
