package control;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import model.Coordinates;

public class Game {
	//泛型为Coordinates,userdList表示位置上已经占用
	private List<Coordinates> usedList = new ArrayList();
	//restList表示位置上空余,可以在下个回合进行插入
	private List<Coordinates> restList = new ArrayList();
	
	public Game(){
		for(int x=0;x<4;x++){
			for(int y=0;y<4;y++){
				restList.add(new Coordinates(x,y,0));
			}
		}
	}
	
	//得到下一个的坐标是多少
	public void next(){
		Random random = new Random();
		//在哪个位置出现
		int number = random.nextInt(restList.size())+1;
		//得到位置对象,准备赋值
		Coordinates tempC = restList.get(number);
		//在restList去除该位置
		restList.remove(number);
		//出现4的概率为0.02
		//出现2的概率为0.98
		int chance = random.nextInt(100)+1;
		
		if(chance<=2){
			tempC.setValue(4);
			//加入链表
			usedList.add(tempC);
		}else{
			tempC.setValue(2);
			usedList.add(tempC);
		}
	}
	
	public List<Coordinates> theRestOfPosition(){
		
		return restList;
		
	}
	
	public List<Coordinates> usedOfPosition(){
		return usedList;
	}

	public void right() {
		
	}

	public void left() {
	}

	public void up() {
	}

	public void down() {
	}
	
	
}
