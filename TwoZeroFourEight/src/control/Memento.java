package control;

class Memento {
	private int[][] used = new int[4][4];
	public Memento(int[][] used){
		this.used = used;
	}
	
	public void setUsed(int[][] used){
		this.used = used;
	}
	
	public int[][] getUsed(){
		return this.used;
	}
}
