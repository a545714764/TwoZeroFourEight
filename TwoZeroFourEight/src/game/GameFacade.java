package game;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import view.MainFrame;

public class GameFacade {
	private Game game = new Game();
	private ViewMove view = new ViewMove();
	private Caretaker caretaker = new Caretaker();
	//���ģʽͳһ��ʼ��game
	public void init(JLayeredPane layeredPane,JLabel scoreLabel){
		Coordinates c =game.next();
		switch(c.getValue()){
		case 2:
			view.viewInit(c,layeredPane);
			game.addScore();
			break;
		case 4:
			view.viewInit(c,layeredPane);
			game.addScore();
			break;
		}
		game.list();
		scoreLabel.setText("����Ϊ:"+game.getScore()+"��");
		caretaker.setMemento(game.saveMemento());
	}
	
	public void left(JLabel scoreLabel){
		caretaker.setMemento(game.saveMemento());
		if(game.canLeft(Game.used)){
    		game.list();
    		view.move(Game.used,MainFrame.layeredPane);
    		game.addScore();
    		scoreLabel.setText("����Ϊ:"+game.getScore()+"��");
    		sentence(scoreLabel);
    	}
	}
	
	public void right(JLabel scoreLabel){
		caretaker.setMemento(game.saveMemento());
		if(game.canRight(Game.used)){
    		game.list();
    		view.move(Game.used,MainFrame.layeredPane);
    		game.addScore();
    		scoreLabel.setText("����Ϊ:"+game.getScore()+"��");
    		sentence(scoreLabel);
    	}
	}
	
	public void up(JLabel scoreLabel){
		caretaker.setMemento(game.saveMemento());
		if(game.canUp(Game.used)){
    		game.list();
    		view.move(Game.used,MainFrame.layeredPane);
    		game.addScore();
    		scoreLabel.setText("����Ϊ:"+game.getScore()+"��");
    		sentence(scoreLabel);
    	}
	}
	
	public void down(JLabel scoreLabel){
		caretaker.setMemento(game.saveMemento());
		if(game.canDown(Game.used)){
    		game.list();
    		view.move(Game.used,MainFrame.layeredPane);
    		game.addScore();
    		scoreLabel.setText("����Ϊ:"+game.getScore()+"��");
    		sentence(scoreLabel);
    	}
	}
	
	public void restore(JLabel scoreLabel){
		game.restoreMemento(caretaker.getMemento());
		game.list();
		view.move(Game.used,MainFrame.layeredPane);
		game.addScore();
		scoreLabel.setText("����Ϊ:"+game.getScore()+"��");
	}
	
	public void restoreTenStep(JLabel scoreLabel){
		game.restoreMemento(caretaker.getTenMemento());
		game.list();
		view.move(Game.used,MainFrame.layeredPane);
		game.addScore();
		scoreLabel.setText("����Ϊ:"+game.getScore()+"��");
	}
	
	//�ж��Ƿ�ͨ�ػ����Ƿ�ʧ��
	public void sentence(JLabel scoreLabel){
		if(game.check2048()){
			Object[] options ={ "���¿�ʼ", "�˳�" };  
			int m = JOptionPane.showOptionDialog(null, "��ϲ��ͨ����!!", "��ϲ",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			if(m==0){
				game.fillZero();
				view.move(Game.used,MainFrame.layeredPane);
				caretaker.removeAll();
				init(MainFrame.layeredPane,scoreLabel);
			}else if(m==1){
				System.exit(0);
			}
		}
		Object[] options ={ "���¿�ʼ", "�˳�" };  
		if(!game.canAll(Game.used)){
			int m = JOptionPane.showOptionDialog(null, "���ź�,��ʧ����!!", "ʧ��",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			if(m==0){
				game.fillZero();
				view.move(Game.used,MainFrame.layeredPane);
				caretaker.removeAll();
				init(MainFrame.layeredPane,scoreLabel);
			}else if(m==1){
				System.exit(0);
			}
		}
	}
}
