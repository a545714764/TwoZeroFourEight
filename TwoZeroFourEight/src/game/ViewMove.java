package game;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import numberPanel.*;
import view.MainFrame;

public class ViewMove {
	
	//按left键时,按2048游戏规则向左移动
	public void move(int[][] after,JLayeredPane layeredPane){
		List<Coordinates> afterList = allHave(after);
		int afterSize = afterList.size();
		layeredPane.removeAll();
		int x = 0;
		int y = 0;
		int value = 0;   
		Coordinates c = null;
		JPanel temp = null;
		layeredPane.add(MainFrame.gamePanel,new Integer(100));
		for(int i=0;i<afterSize;i++){
			x = afterList.get(i).getX();
			y = afterList.get(i).getY();
			value = afterList.get(i).getValue();
			c = changeArrayToConcreteCoordinates(x, y, value);
			temp = NumberFactory.createNumber(value);
			temp.setBounds(c.getX(),c.getY(), 100, 100);
			layeredPane.add(temp,new Integer(200));
		}
		
	}
	
		
	public void viewInit(Coordinates c,JLayeredPane layeredPane){
		int x = c.getX();
		int y = c.getY();
		int value = c.getValue();
		
		Coordinates temp1 = changeArrayToConcreteCoordinates(x, y, value);
		JPanel temp = NumberFactory.createNumber(value);
		temp.setBounds(temp1.getX(),temp1.getY(), 100, 100);
		layeredPane.add(temp,new Integer(200));
	}
	
	//将简单的(0,1)坐标转化为真实的绝对坐标(30,135)
	public Coordinates changeArrayToConcreteCoordinates(int x,int y,int value){
		int concreteX = 0;
		int concreteY = 0;
		switch(x){
			case 0:
				concreteX = 30;
				break;
			case 1:
				concreteX = 135;
				break;
			case 2:
				concreteX = 240;
				break;
			case 3:
				concreteX = 345;
				break;
		}
		switch(y){
		case 0:
			concreteY = 30;
			break;
		case 1:
			concreteY = 135;
			break;
		case 2:
			concreteY = 240;
			break;
		case 3:
			concreteY = 345;
			break;		
		}
		return new Coordinates(concreteY,concreteX,value);
	}
	
	//在横向右多少个不为0的数字,如果有,则放到数组a中
	//参数upDown:在第几行
	public List<Coordinates> leftRightHave(int upDown,int[][] temp){
		List<Coordinates> list = new ArrayList();
		Coordinates c;
		for(int leftRight=0;leftRight<4;leftRight++){
			if(temp[upDown][leftRight]!=0){
				int x = upDown;
				int y = leftRight;
				int value = temp[upDown][leftRight];
				c = new Coordinates(x,y,value);
				list.add(c);
			}
		}
		return list;
	}
	
	//在纵向向下多少个不为0的数字,如果有,则放到数组a中
	//参数leftRight:在第几行
	public List<Coordinates> upDownHave(int leftRight){
		List<Coordinates> list = new ArrayList();
		Coordinates c;
		for(int upDown=0;upDown<4;upDown++){
			if(Game.used[upDown][leftRight]!=0){
				int x = upDown;
				int y = leftRight;
				int value = Game.used[upDown][leftRight];
				c = new Coordinates(x,y,value);
				list.add(c);
			}
		}
		return list;
	}
	
	public List<Coordinates> allHave(int[][] after){
		List<Coordinates> list = new ArrayList();
		Coordinates c;
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				if(after[i][j]!=0){
					int x =i;
					int y =j;
					int value = after[i][j];
					c = new Coordinates(x,y,value);
					list.add(c);
				}
			}
		}
		return list;
		
	}
}
