package control;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import model.Coordinates;

public class Game {
	//����ΪCoordinates,userdList��ʾλ�����Ѿ�ռ��
	private List<Coordinates> usedList = new ArrayList();
	//restList��ʾλ���Ͽ���,�������¸��غϽ��в���
	private List<Coordinates> restList = new ArrayList();
	
	public Game(){
		for(int x=0;x<4;x++){
			for(int y=0;y<4;y++){
				restList.add(new Coordinates(x,y,0));
			}
		}
	}
	
	//�õ���һ���������Ƕ���
	public void next(){
		Random random = new Random();
		//���ĸ�λ�ó���
		int number = random.nextInt(restList.size())+1;
		//�õ�λ�ö���,׼����ֵ
		Coordinates tempC = restList.get(number);
		//��restListȥ����λ��
		restList.remove(number);
		//����4�ĸ���Ϊ0.02
		//����2�ĸ���Ϊ0.98
		int chance = random.nextInt(100)+1;
		
		if(chance<=2){
			tempC.setValue(4);
			//��������
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
