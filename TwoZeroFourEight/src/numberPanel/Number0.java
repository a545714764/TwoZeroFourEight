package numberPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.io.Serializable;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Coordinates;

public class Number0 extends JPanel implements  Serializable{
	private Coordinates coordinate;
	private JLabel numberLabel;
	public Number0(){
		
	}
	public Number0(Coordinates coordinate){
//		this.setSize(150,150);
		//��������
		this.coordinate = coordinate;
		//������������ΪBorderLayout
		this.setLayout(new BorderLayout());
		numberLabel = new JLabel();
		numberLabel.setFont(new Font("Arial",Font.BOLD,60));//����������ʽ
		//����������ɫ,"4"����(������4)������ɫ��ʾΪ��ɫ
		numberLabel.setForeground(Color.BLACK);							
		//��������ˮƽ����
		numberLabel.setHorizontalAlignment(JLabel.CENTER);		
		//���ñ�ǩ����Ϊ2
//		numberLabel.setText("0");
		//���ñ�ǩ����������
		this.add(numberLabel,BorderLayout.CENTER);
		//��������������ɫ
		this.setBackground(new Color(187,173,160));
//		this.setBackground(Color.white);
	}
	//����ͼƬ
	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);
		Image bgImg = null;
		 try {
			 bgImg = ImageIO.read(new File("TwoZeroFourEight/src/image/0.png"));
		 } catch (IOException e) {
			 e.printStackTrace();
		 }
		 arg0.drawImage(bgImg, -25, -25,
					null);
	}
	
	public Object deepClone() throws IOException,ClassNotFoundException,OptionalDataException{
		//������д������
		ByteArrayOutputStream bao = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bao);
		oos.writeObject(this);
		
		ByteArrayInputStream bis = new ByteArrayInputStream(bao.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bis);
		return (ois.readObject());
	}
	 
  
}
