package view;


import javax.swing.JFrame;
import javax.swing.JPanel;


//单例模式:保证主窗口只有一个,不会重复
public class MainFrame extends JFrame{
	private JPanel mainPanel;
	private JPanel topPanel;
//	private JPanel gamePanel;
	
	public MainFrame(){
		
		topPanel = new TopPanel();
		mainPanel = new JPanel();
//		gamePanel = new GamePanel();
		
		topPanel.setBounds(0, 0, 550, 40);
//		gamePanel.setBounds(50, 50, 435, 435);
	    
		this.setTitle("2048");
		this.getContentPane().add(mainPanel);
		
		this.setSize(550,560);

		mainPanel.setLayout(null);
		mainPanel.add(topPanel);
//		mainPanel.add(gamePanel);
		this.repaint();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	
}
