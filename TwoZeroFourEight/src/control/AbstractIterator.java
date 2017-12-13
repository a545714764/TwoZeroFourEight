package control;

public interface AbstractIterator {
	//下一个位置
	public void next();
	public boolean isEmpty();
	public int size();
	public int restSize();
	
//	public void next();
//	public boolean isLast();
//	public void previous();
//	public boolean isFirst();
//	public String getNextItem();
//	public String getPreviousItem();
//	void setChannel(int i);
//	void next();
//	void previous();
//	boolean isLast();
//	Object currentChannel();
//	boolean isFirst();
}
