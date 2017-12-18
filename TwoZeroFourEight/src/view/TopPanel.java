package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.GameFacade;
import control.Caretaker;
import control.Game;
import control.ViewMove;
import sun.net.www.content.image.gif;

public class TopPanel extends JPanel{
	GameFacade facade = new GameFacade();
	private JLabel scoreLabel;
	private JButton backButton;
	private JButton backTenStepButton;
	
	public TopPanel(){
		scoreLabel = new JLabel("分数为:0分");
		backButton = new JButton("后退一步");
		backTenStepButton = new JButton("后退十步");
		this.add(scoreLabel);
		this.add(backButton);
		this.add(backTenStepButton);
		facade.init(MainFrame.layeredPane,scoreLabel);
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				facade.restore(scoreLabel);
			}
		});
		backTenStepButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				facade.restoreTenStep(scoreLabel);
				backButton.requestFocus();
			}
		});
		backButton.addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent e){
                switch(e.getKeyCode()){
                case KeyEvent.VK_DOWN: 
                	facade.down(scoreLabel);
                	break;
                case KeyEvent.VK_UP: 
                	facade.up(scoreLabel);
                	break;
                case KeyEvent.VK_LEFT:
                	facade.left(scoreLabel);
                	break;
                case KeyEvent.VK_RIGHT: 
                	facade.right(scoreLabel);
                	break;
                default: 
           
                	break;
               }
            }
		});
	}
	
}
