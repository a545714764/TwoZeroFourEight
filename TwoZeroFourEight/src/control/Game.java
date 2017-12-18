package control;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.Coordinates;

public class Game{
	ViewMove view = new ViewMove();
	public static int[][] used = new int[4][4];
	public static int score = 0;
	private List<Coordinates> rest = new ArrayList<>();
	
	public Game(){		
		fillZero();
		
	}
	
	public Coordinates next(){
		Random random = new Random();
		int position = random.nextInt(rest.size());
		Coordinates tempC = rest.get(position);
		//��restListȥ����λ��
		rest.remove(position);
		//����4�ĸ���Ϊ0.02
		//����2�ĸ���Ϊ0.98
		int chance = random.nextInt(100)+1;
		int x = tempC.getX();
		int y = tempC.getY();
		if(chance<=2){
			//������(x,y)��ֵΪ4
			used[x][y]=4;
			return new Coordinates(x,y,4);
		}else{
			used[x][y]=2;
			return new Coordinates(x,y,2);
		}
	}
	
	//��������
	public void list(){
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				System.out.printf("%4s",used[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println("------------------------------");
	}
	
	//����ʣ��λ��List
	public void changeRest(){
		rest.clear();
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				if(used[i][j]==0){
					Coordinates c = new Coordinates(i,j,0);
					rest.add(c);
				}
			}
		}
	}
	
	//�ܷ������ƶ�,�����,����usedλ��,������һ������
	public boolean canRight(int[][] beforeList){
		int[][] afterList = new int[4][4];
		afterList = right();
		if(isEqual(afterList, beforeList)){
			return false;
		}else{
			used = afterList;
			changeRest();
			next();  
			
			return true;
		}
	}
	
	//�ܷ������ƶ�,�����,����usedλ��,������һ������
	public boolean canLeft(int[][] beforeList){
		int[][] afterList = new int[4][4];
		afterList = left();
		if(isEqual(afterList, beforeList)){
			return false;
		}else{
			used = afterList;
			changeRest();
			next();
			return true;
		}
	}
	
	public boolean canAll(int[][] beforeList){
		int[][] left = new int[4][4];
		int[][] right = new int[4][4];
		int[][] up = new int[4][4];
		int[][] down = new int[4][4];
		left = left();
		right = right();
		up = up();
		down = down();
		if(isEqual(left, beforeList)&&isEqual(right, beforeList)&&
				isEqual(up, beforeList)&&isEqual(down, beforeList)){
			return false;
		}else{
			return true;
		}
			
	}
	
	//�ܷ������ƶ�,�����,����usedλ��,������һ������
	public boolean canUp(int[][] beforeList){
		int[][] afterList = new int[4][4];
		afterList = up();
		if(isEqual(afterList, beforeList)){
			return false;
		}else{
			used = afterList;
			changeRest();
			next();
			return true;
		}
	}
	
	//�ܷ������ƶ�,�����,����usedλ��,������һ������
	public boolean canDown(int[][] beforeList){
		int[][] afterList = new int[4][4];
		afterList = down();
		if(isEqual(afterList, beforeList)){
			return false;
		}else{
			used = afterList;
			changeRest();
			next();
			return true;
		}
	}
	
	
	//����Ұ���right��ʱ�����ú���
	public int[][] right(){
		/*
		 * 2 0 0 0 upDown=0     
		 * 2 0 0 0 upDown=1        
		 * 2 0 0 0 upDown=2
		 * 2 0 0 0 upDown=3
		 * 
		 * leftRight=0 leftRight=1 leftRight=2 leftRight=3
		 * 2 2 2 2 
		 * 0 0 0 0
		 * 0 0 0 0
		 * 0 0 0 0 
		 */
		int[][] afterList = new int[4][4];
		for(int upDown =0;upDown<4;upDown++){
			List<Integer> list =comboRight(leftRightHave(upDown));
			int size = list.size();
			int max = 3;
			for(int i=size-1;i>=0;i--){
				afterList[upDown][max--] = list.get(i);
			}
			//��������0
			for(int i=max;i>=0;i--){
				afterList[upDown][i] = 0;
			}
		}
		return afterList;
	}
	
	//����Ұ���Left��ʱ�����ú���
	public int[][] left(){
		int[][] afterList = new int[4][4];
		for(int upDown =0;upDown<4;upDown++){
			List<Integer> list =comboLeft(leftRightHave(upDown));
			int size = list.size();
			int min = 0;
			for(int i=0;i<=size-1;i++){
				afterList[upDown][min++] = list.get(i);
			}
			//��������0
			for(int i=min;i<=3;i++){
				afterList[upDown][i] = 0;
			}
		}
		return afterList;
	}
	
	//����Ұ���up��ʱ�����ú���
	public int[][] up(){
		int[][] afterList = new int[4][4];
		for(int leftRight=0;leftRight<4;leftRight++){
			List<Integer> list = comboUp(upDownHave(leftRight));
			int size = list.size();
			int min = 0;
			for(int i =0;i<=size-1;i++){
				afterList[min++][leftRight] = list.get(i);
			}
			//��������0
			for(int i=min;i<=3;i++){
				afterList[i][leftRight] = 0;
			}
		}
		return afterList;
	}
	
	//����Ұ���down���Ǵ����ú���
	public int[][] down(){
		int[][] afterList = new int[4][4];
		for(int leftRight=0;leftRight<4;leftRight++){
			List<Integer> list = comboUp(upDownHave(leftRight));
			int size = list.size();
			int max = 3;
			for(int i=size-1;i>=0;i--){
				afterList[max--][leftRight] = list.get(i);
			}
			//��������0
			for(int i=max;i>=0;i--){
				afterList[i][leftRight] = 0 ;
			}
		}
		return afterList;
	}
	//�ں����Ҷ��ٸ���Ϊ0������,�����,��ŵ�����a��
	//����upDown:�ڵڼ���
	public List<Integer> leftRightHave(int upDown){
		List<Integer> list = new ArrayList();
		for(int leftRight=0;leftRight<4;leftRight++){
			if(used[upDown][leftRight]!=0){
				list.add(used[upDown][leftRight]);
			}
		}
		return list;
	}
	
	//���������¶��ٸ���Ϊ0������,�����,��ŵ�����a��
	//����leftRight:�ڵڼ���
	public List<Integer> upDownHave(int leftRight){
		List<Integer> list = new ArrayList();
		for(int upDown=0;upDown<4;upDown++){
			if(used[upDown][leftRight]!=0){
				list.add(used[upDown][leftRight]);
			}
		}
		return list;
	}
		
		
	//�ں���(����),����2048��Ϸ����,�ϲ���ͬ������
	public List<Integer> comboRight(List<Integer> list){
		List<Integer> afterList = new ArrayList();
		switch(list.size()){
			case 1:
				return list;
			case 2:
				if(list.get(1).equals(list.get(0))){
					int sum = list.get(0)*2;
					afterList.add(sum);
					return afterList;
				}else{
					return list;
				}
			case 3:
				//2 2 2 0 �ϲ�Ϊ 2 4 0
				//���ҵ���
				if(list.get(2).equals(list.get(1))){
					afterList.add(list.get(0));
					int sum = list.get(2)*2;
					afterList.add(sum);
					return afterList;
				}else if(list.get(1).equals(list.get(0))){
					int sum = list.get(1)*2;
					afterList.add(sum);
					afterList.add(list.get(2));
					return afterList;
				}else{
					return list;
				}
			case 4:
				//2 2 2 2 �ϲ�Ϊ 0 0 4 4
				//2 2 2 4 �ϲ�Ϊ 0 2 4 4
				//2 4 8 8 �ϲ�Ϊ 0 2 4 16
				//2 2 4 8 �ϲ�Ϊ 0 4 4 8
				//2 4 8 16 ���ϲ�
				if(list.get(3).equals(list.get(2))&&list.get(1).equals(list.get(0))){
					int sum1 = list.get(3)*2;
					int sum2 = list.get(1)*2;
					afterList.add(sum2);
					afterList.add(sum1);
					return afterList;
				}else if(list.get(3).equals(list.get(2))){
					int sum = list.get(3)*2;
					afterList.add(list.get(0));
					afterList.add(list.get(1));
					afterList.add(sum);
					return afterList;
				}else if(list.get(2).equals(list.get(1))){
					int sum = list.get(2)*2;
					afterList.add(list.get(0));
					afterList.add(sum);
					afterList.add(list.get(3));
					return afterList;
				}else if(list.get(0).equals(list.get(1))){
					int sum = list.get(0)*2;
					afterList.add(sum);
					afterList.add(list.get(2));
					afterList.add(list.get(3));
					return afterList;
				}else{
					return list;
				}
			
		}
		return afterList;
	}
	
	//�ں���(����),����2048��Ϸ����,�ϲ���ͬ������
	public List<Integer> comboLeft(List<Integer> list){
		List<Integer> afterList = new ArrayList();
		switch(list.size()){
			case 1:
				return list;
			case 2:
				if(list.get(0).equals(list.get(1))){
					int sum = list.get(0)*2;
					afterList.add(sum);
					return afterList;
				}else{
					return list;
				}
			case 3:
				//2 2 2 0 �ϲ�Ϊ 4 2 0
				//������
				if(list.get(0).equals(list.get(1))){
					int sum = list.get(0)*2;
					afterList.add(sum);
					afterList.add(list.get(2));
					return afterList;
				}else if(list.get(1).equals(list.get(2))){
					int sum = list.get(1)*2;
					afterList.add(list.get(0));
					afterList.add(sum);
					return afterList;
				}else{
					return list;
				}
			case 4:
				//2 2 2 2 �ϲ�Ϊ 4 4 0 0
				//2 2 2 4 �ϲ�Ϊ 0 2 4 4
				//2 4 8 8 �ϲ�Ϊ 0 2 4 16
				//2 2 4 8 �ϲ�Ϊ 0 4 4 8
				//2 4 8 16 ���ϲ�
				if(list.get(3).equals(list.get(2))&&list.get(1).equals(list.get(0))){
					int sum1 = list.get(3)*2;
					int sum2 = list.get(1)*2;
					afterList.add(sum2);
					afterList.add(sum1);
					return afterList;
				}else if(list.get(0).equals(list.get(1))){
					int sum = list.get(0)*2;
					afterList.add(sum);
					afterList.add(list.get(2));
					afterList.add(list.get(3));
					return afterList;
				}else if(list.get(1).equals(list.get(2))){
					int sum = list.get(2)*2;
					afterList.add(list.get(0));
					afterList.add(sum);
					afterList.add(list.get(3));
					return afterList;
				}else if(list.get(2).equals(list.get(3))){
					int sum = list.get(3)*2;
					afterList.add(list.get(0));
					afterList.add(list.get(1));
					afterList.add(sum);
					return afterList;
				}else{
					return list;
				}		
		}
		return afterList;
	}
	
	//������(����),����2048��Ϸ����,�ϲ���ͬ������
	public List<Integer> comboUp(List<Integer> list){
		List<Integer> afterList = new ArrayList();
		switch(list.size()){
			case 1:
				return list;
			case 2:
				if(list.get(0).equals(list.get(1))){
					int sum = list.get(0) + list.get(1);
					afterList.add(sum);
					return afterList;
				}else{
					return list;
				}
			case 3:
				//2 0 0 0
				//2 0 0 0
				//2 0 0 0
				//0 0 0 0 
				//�ϲ�Ϊ
				//4 0 0 0
				//2 0 0 0
				//0 0 0 0
				//0 0 0 0
				if(list.get(0).equals(list.get(1))){
					int sum = list.get(0) + list.get(1);
					afterList.add(sum);
					afterList.add(list.get(2));
					return afterList;
				}else if(list.get(1).equals(list.get(2))){
					int sum = list.get(1)*2;
					afterList.add(list.get(0));
					afterList.add(sum);
					return afterList;
				}else{
					return list;
				}
			case 4:
				if(list.get(0).equals(list.get(1))&&list.get(2).equals(list.get(3))){
					int sum1 = list.get(0)*2;
					int sum2 = list.get(2)*2;
					afterList.add(sum1);
					afterList.add(sum2);
					return afterList;
				}else if(list.get(0).equals(list.get(1))){
					int sum = list.get(0)*2;
					afterList.add(sum);
					afterList.add(list.get(2));
					afterList.add(list.get(3));
					return afterList;
				}else if(list.get(1).equals(list.get(2))){
					int sum = list.get(1)*2;
					afterList.add(list.get(0));
					afterList.add(sum);
					afterList.add(list.get(3));
					return afterList;
				}else if(list.get(2).equals(list.get(3))){
					int sum = list.get(2)*2;
					afterList.add(list.get(0));
					afterList.add(list.get(1));
					afterList.add(sum);
					return afterList;
				}else{
					return list;
				}
				
		}
		return list;
	}
	
	//������(����),����2048��Ϸ����,�ϲ���ͬ������
	public List<Integer> comboDown(List<Integer> list){
		List<Integer> afterList = new ArrayList();
		switch(list.size()){
			case 1:
				return list;
			case 2:
				if(list.get(0).equals(list.get(1))){
					int sum = list.get(0) + list.get(1);
					afterList.add(sum);
					return afterList;
				}else{
					return list;
				}
			case 3:
				//0 0 0 0 |0 0 0 0
				//2 0 0 0 |2 0 0 0
				//2 0 0 0 |2 0 0 0
				//2 0 0 0 |4 0 0 0
				//�ϲ�Ϊ         |
				//0 0 0 0 |0 0 0 0
				//0 0 0 0 |0 0 0 0
				//2 0 0 0 |4 0 0 0
				//4 0 0 0 |4 0 0 0
				if(list.get(2).equals(list.get(1))){
					int sum = list.get(2)*2;
					afterList.add(list.get(0));
					afterList.add(sum);
					return afterList;
				}else if(list.get(1).equals(list.get(0))){
					int sum = list.get(0);
					afterList.add(sum);
					afterList.add(list.get(2));
					return afterList;
				}else{
					return list;
				}
			case 4:
				if(list.get(3).equals(list.get(2))&&list.get(1).equals(list.get(0))){
					int sum1 = list.get(3)*2;
					int sum2 = list.get(1)*2;
					afterList.add(sum2);
					afterList.add(sum1);
					return afterList;
				}else if(list.get(3).equals(list.get(2))){
					int sum = list.get(3)*2;
					afterList.add(list.get(0));
					afterList.add(list.get(1));
					afterList.add(sum);
					return afterList;
				}else if(list.get(2).equals(list.get(1))){
					int sum = list.get(2)*2;
					afterList.add(list.get(0));
					afterList.add(sum);
					afterList.add(list.get(3));
					return afterList;
				}else if(list.get(1).equals(list.get(0))){
					int sum = list.get(1)*2;
					afterList.add(sum);
					afterList.add(list.get(2));
					afterList.add(list.get(3));
					return afterList;
				}else{
					return list;
				}
				
		}
		return list;
	}
	
	//�ж϶�ά�����Ƿ����
	public boolean isEqual(int[][] a,int[][] b){
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				if(a[i][j]!=b[i][j]){
					return false;
				}
			}
		}
		return true;
	}

	public void addScore(){
		score = 0;
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				score+=used[i][j];
			}
		}
		System.out.println("����Ϊ:"+score);
	}
	
	public int getScore(){
		return this.score;
	}
	
	public Memento saveMemento(){
		return new Memento(used);
	}
	
	public void restoreMemento(Memento memento){
		Game.used = memento.getUsed();
	}
	
	//��used����,�������¿�ʼ
	public void fillZero(){
		for(int i = 0;i<4;i++){
			for(int j=0;j<4;j++){
				used[i][j] = 0;
				Coordinates coordinate = new Coordinates(i,j,0);
				rest.add(coordinate);
			}
		}
	}
}
