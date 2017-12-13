package view;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.GameList;
import sun.net.www.content.image.gif;

public class TopPanel extends JPanel{
	GameList game = new GameList();
	private static JLabel scoreLabel;
	private static int score;
	private JButton backButton;
	private JButton backTenStepButton;
	public TopPanel(){
		scoreLabel = new JLabel(score+"分");
		backButton = new JButton("后退一步");
		backTenStepButton = new JButton("后退十步");
		backButton.addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent e){
                switch(e.getKeyCode()){
                case KeyEvent.VK_DOWN: 
                	if(game.canDown(GameList.used)){
                		game.list();
                	}
                	break;
                case KeyEvent.VK_UP: 
                	if(game.canUp(GameList.used)){
                		game.list();
                	}
                	break;
                case KeyEvent.VK_LEFT:
                	if(game.canLeft(GameList.used)){
                		game.list();
                	}
                	break;
                case KeyEvent.VK_RIGHT: 
                	if(game.canRight(GameList.used)){
                		game.list();
                	}
                	break;
                default: 
           
                	break;
               }
            }
		});
		this.add(scoreLabel);
		this.add(backButton);
		this.add(backTenStepButton);
	}
}
