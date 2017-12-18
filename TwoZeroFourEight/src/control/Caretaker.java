package control;

import java.util.ArrayList;
import java.util.List;

public class Caretaker {
	private List<Memento> memento = new ArrayList();
	public Memento getMemento(){
		Memento  temp;
		System.out.println(memento.size());
		if(memento.size()!=1){
			temp= memento.get(memento.size()-1);
			memento.remove(temp);
			return temp;
		}else{
			temp= memento.get(memento.size()-1);
			return temp;
		}
		
	}
	public void setMemento(Memento memento){
		
		this.memento.add(memento);
		if(this.memento.size()>=2){
			if(isEqual(this.memento.get(this.memento.size()-1).getUsed(), 
					this.memento.get(this.memento.size()-2).getUsed())){
				this.memento.remove(this.memento.size()-1);
			}
		}
		
	}
	
	public Memento getTenMemento(){
		Memento temp = null;
		if(memento.size()>=10){
			temp= memento.get(memento.size()-10);
			int size = memento.size()-9;
			for(int i=1;i<=9;i++){
				memento.remove(size);
			}
			return temp;
		}else if(memento.size()!=1){
			temp= memento.get(memento.size()-1);
			memento.remove(temp);
			return temp;
		}else{
			temp= memento.get(memento.size()-1);
			return temp;
		}
		
	}
	//判断二维数组是否相等
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
	
	public void removeAll(){
		this.memento.clear();
	}
}
