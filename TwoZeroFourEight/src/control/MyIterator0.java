package control;
import model.Coordinates;

public class MyIterator0 implements AbstractIterator {
	private Coordinates[] coordinates;
	private int indexOfx;
	private int indexOfy;
	public MyIterator0(AbstractCoordinatesList list){
		coordinates= list.getCoordinates();
		indexOfx = 0;
		indexOfy = 0;
	}
	@Override
	public void next() {
	}

	@Override
	public boolean isEmpty() {

		return false;
	}

	@Override
	public int size() {

		return 0;
	}

	@Override
	public int restSize() {

		return 0;
	}

}
