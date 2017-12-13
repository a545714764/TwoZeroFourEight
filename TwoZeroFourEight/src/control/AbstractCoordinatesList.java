package control;


import model.Coordinates;

public abstract class AbstractCoordinatesList {
	private Coordinates[] coordinates;
	public AbstractCoordinatesList(Coordinates[] coordinates){
		this.coordinates = coordinates;
	}
	public Coordinates[] getCoordinates(){
		
		return this.coordinates;
	}
	public abstract AbstractIterator getIterator();
}
