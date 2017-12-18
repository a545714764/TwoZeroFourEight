package view;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.OptionalDataException;

import javax.swing.JPanel;


import model.Coordinates;
import numberPanel.*;

public class GamePanel extends JPanel {
	
	private Number0 number0_0;
	private Number0 number0_1;
	private Number0 number0_2;
	private Number0 number0_3;
	private Number0 number0_4;
	private Number0 number0_5;
	private Number0 number0_6;
	private Number0 number0_7;
	private Number0 number0_8;
	private Number0 number0_9;
	private Number0 number0_10;
	private Number0 number0_11;
	private Number0 number0_12;
	private Number0 number0_13;
	private Number0 number0_14;
	private Number0 number0_15;
	
	public GamePanel() throws OptionalDataException, ClassNotFoundException, IOException{
		this.setLayout(null);
		
		number0_0 = new Number0(new Coordinates(0, 0,0));
//		number0_1 = new Number0(new Coordinates(0, 1,0));
		number0_1 = (Number0) number0_0.deepClone();
		number0_2 = (Number0) number0_0.deepClone();
		number0_3 = (Number0) number0_0.deepClone();
		number0_4 = (Number0) number0_0.deepClone();
		number0_5 = (Number0) number0_0.deepClone();
		number0_6 = (Number0) number0_0.deepClone();
		number0_7 = (Number0) number0_0.deepClone();
		number0_8 = (Number0) number0_0.deepClone();
		number0_9 = (Number0) number0_0.deepClone();
		number0_10 = (Number0) number0_0.deepClone();
		number0_11 = (Number0) number0_0.deepClone();
		number0_12 = (Number0) number0_0.deepClone();
		number0_13 = (Number0) number0_0.deepClone();
		number0_14 = (Number0) number0_0.deepClone();
		number0_15 = (Number0) number0_0.deepClone();
		
		number0_0.setBounds(10, 10, 100, 100);
		number0_1.setBounds(115, 10, 100, 100);
		number0_2.setBounds(220, 10, 100, 100);
		number0_3.setBounds(325, 10, 100, 100);
		                        
		
		number0_4.setBounds(10, 115, 100, 100);
		number0_5.setBounds(115, 115, 100, 100);
		number0_6.setBounds(220, 115, 100, 100);
		number0_7.setBounds(325, 115, 100, 100);
		
		
		number0_8.setBounds(10, 220, 100, 100);
		number0_9.setBounds(115, 220, 100, 100);
		number0_10.setBounds(220, 220, 100, 100);
		number0_11.setBounds(325, 220, 100, 100);
		
		number0_12.setBounds(10, 325, 100, 100);
		number0_13.setBounds(115, 325, 100, 100);
		number0_14.setBounds(220, 325, 100, 100);
		number0_15.setBounds(325, 325, 100, 100);
		
		this.add(number0_0);
		this.add(number0_1);
		this.add(number0_2);
		this.add(number0_3);
		this.add(number0_4);
		this.add(number0_5);
		this.add(number0_6);
		this.add(number0_7);
		this.add(number0_8);
		this.add(number0_9);
		this.add(number0_10);
		this.add(number0_11);
		this.add(number0_12);
		this.add(number0_13);
		this.add(number0_14);
		this.add(number0_15);
		this.setBackground(new Color(187,173,160));
		this.setVisible(true);
	}
	
}
