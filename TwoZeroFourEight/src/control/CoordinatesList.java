package control;

import model.Coordinates;

public class CoordinatesList extends AbstractCoordinatesList {
	public CoordinatesList(Coordinates[] coordinates){
		super(coordinates);
	}
	@Override
	public AbstractIterator getIterator() {

		return new MyIterator0(this);
	}

}
