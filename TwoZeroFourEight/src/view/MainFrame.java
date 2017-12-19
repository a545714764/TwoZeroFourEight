package view;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.OptionalDataException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import game.Coordinates;
import game.Game;
import game.ViewMove;
import numberPanel.*;


//单例模式:保证主窗口只有一个,不会重复
public class MainFrame extends JFrame{
	private JPanel mainPanel;
	private JPanel topPanel;
	public static JPanel gamePanel;
	public static JLayeredPane layeredPane;
	Game game = new Game();
	ViewMove view = new ViewMove();
	
	public MainFrame() throws OptionalDataException, ClassNotFoundException, IOException{
		mainPanel = new JPanel();
		gamePanel = new GamePanel();
		layeredPane = new JLayeredPane();
		topPanel = new TopPanel();
		
		topPanel.setBounds(0, 0, 550, 40);
		gamePanel.setBounds(20, 20, 460, 460);
		layeredPane.setBounds(20, 20, 460, 460);
		
		this.setTitle("2048");
		this.getContentPane().add(mainPanel);
		
		this.setSize(550,560);

		mainPanel.setLayout(null);
		mainPanel.add(topPanel);
		layeredPane.add(gamePanel,new Integer(100));
		mainPanel.add(layeredPane);
		this.repaint();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
