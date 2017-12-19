package game;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import view.MainFrame;

public class GameFacade {
	private Game game = new Game();
	private ViewMove view = new ViewMove();
	private Caretaker caretaker = new Caretaker();
	//外观模式统一初始化game
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
		scoreLabel.setText("分数为:"+game.getScore()+"分");
		caretaker.setMemento(game.saveMemento());
	}
	
	public void left(JLabel scoreLabel){
		caretaker.setMemento(game.saveMemento());
		if(game.canLeft(Game.used)){
    		game.list();
    		view.move(Game.used,MainFrame.layeredPane);
    		game.addScore();
    		scoreLabel.setText("分数为:"+game.getScore()+"分");
    		sentence(scoreLabel);
    	}
	}
	
	public void right(JLabel scoreLabel){
		caretaker.setMemento(game.saveMemento());
		if(game.canRight(Game.used)){
    		game.list();
    		view.move(Game.used,MainFrame.layeredPane);
    		game.addScore();
    		scoreLabel.setText("分数为:"+game.getScore()+"分");
    		sentence(scoreLabel);
    	}
	}
	
	public void up(JLabel scoreLabel){
		caretaker.setMemento(game.saveMemento());
		if(game.canUp(Game.used)){
    		game.list();
    		view.move(Game.used,MainFrame.layeredPane);
    		game.addScore();
    		scoreLabel.setText("分数为:"+game.getScore()+"分");
    		sentence(scoreLabel);
    	}
	}
	
	public void down(JLabel scoreLabel){
		caretaker.setMemento(game.saveMemento());
		if(game.canDown(Game.used)){
    		game.list();
    		view.move(Game.used,MainFrame.layeredPane);
    		game.addScore();
    		scoreLabel.setText("分数为:"+game.getScore()+"分");
    		sentence(scoreLabel);
    	}
	}
	
	public void restore(JLabel scoreLabel){
		game.restoreMemento(caretaker.getMemento());
		game.list();
		view.move(Game.used,MainFrame.layeredPane);
		game.addScore();
		scoreLabel.setText("分数为:"+game.getScore()+"分");
	}
	
	public void restoreTenStep(JLabel scoreLabel){
		game.restoreMemento(caretaker.getTenMemento());
		game.list();
		view.move(Game.used,MainFrame.layeredPane);
		game.addScore();
		scoreLabel.setText("分数为:"+game.getScore()+"分");
	}
	
	//判断是否通关或者是否失败
	public void sentence(JLabel scoreLabel){
		if(game.check2048()){
			Object[] options ={ "重新开始", "退出" };  
			int m = JOptionPane.showOptionDialog(null, "恭喜你通关啦!!", "恭喜",
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
		Object[] options ={ "重新开始", "退出" };  
		if(!game.canAll(Game.used)){
			int m = JOptionPane.showOptionDialog(null, "很遗憾,你失败了!!", "失败",
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
