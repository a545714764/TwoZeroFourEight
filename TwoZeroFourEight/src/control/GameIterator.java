package control;

public interface GameIterator {
	void next();
	boolean isLast();
	boolean isFirst();
	int getNextItem();
}
