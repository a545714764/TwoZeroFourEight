package view;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
	
	
	
	
	private Number2 number2;
	private Number4 number4;
	private Number8 number8;
	private Number16 number16;
	private Number32 number32;
	private Number64 number64;
	private Number128 number128;
	private Number256 number256;
	private Number512 number512;
	private Number1024 number1024;
	private Number2048 number2048;
	
	
	public GamePanel(){
		
		this.setLayout(null);
		
//		number0_0 = new Number0(new Coordinates(0, 0));
//		number0_1 = new Number0(new Coordinates(0, 1));
//		number0_2 = new Number0(new Coordinates(0, 2));
//		number0_3 = new Number0(new Coordinates(0, 3));
//		number0_4 = new Number0(new Coordinates(1, 0));
//		number0_5 = new Number0(new Coordinates(1, 1));
//		number0_6 = new Number0(new Coordinates(1, 2));
//		number0_7 = new Number0(new Coordinates(1, 3));
//		number0_8 = new Number0(new Coordinates(2, 0));
//		number0_9 = new Number0(new Coordinates(2, 1));
//		number0_10 = new Number0(new Coordinates(2, 2));
//		number0_11 = new Number0(new Coordinates(2, 3));
//		number0_12 = new Number0(new Coordinates(3, 0));
//		number0_13 = new Number0(new Coordinates(3, 1));
//		number0_14 = new Number0(new Coordinates(3, 2));
//		number0_15 = new Number0(new Coordinates(3, 3));
//
//		number2 = new Number2(new Coordinates(0, 1));
//		number4 = new Number4(new Coordinates(0, 2));
//		number8 = new Number8(new Coordinates(0, 3));
//		number16 = new Number16(new Coordinates(1, 0));
//		number32 = new Number32(new Coordinates(1, 1));
//		number64 = new Number64(new Coordinates(1, 2));
//		number128 = new Number128(new Coordinates(1, 3));
//		number256 = new Number256(new Coordinates(2, 0));
//		number512 = new Number512(new Coordinates(2, 1));
//		number1024 = new Number1024(new Coordinates(2, 2));
//		number2048 = new Number2048(new Coordinates(2, 3));
		
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
		

		
//		this.add(number4);
//		this.add(number8);
//		this.add(number16);
//		this.add(number32);
//		this.add(number64);
//		this.add(number128);
//		this.add(number256);
//		this.add(number512);
//		this.add(number1024);
//		this.add(number2048);
		
		
		this.setBackground(new Color(187,173,160));
//		this.setOpaque(false);
		this.setVisible(true);
	}
	
}
