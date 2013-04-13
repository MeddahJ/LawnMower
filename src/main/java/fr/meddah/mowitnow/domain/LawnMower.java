package fr.meddah.mowitnow.domain;

import static java.lang.Integer.*;

public class LawnMower {

	public static LawnMower buildLawnMower(String state) {
		String[] lawnMowerState = state.split(" ");
		Coordinates coordinates = new Coordinates(parseInt(lawnMowerState[0]), parseInt(lawnMowerState[1]));
		Orientation orientation = Orientation.valueOf(lawnMowerState[2]);
		return new LawnMower(coordinates, orientation);
	}

	LawnMower withNewCoordinates(Coordinates newCoordinates) {
		return new LawnMower(newCoordinates, orientation);
	}

	LawnMower withNewOrientation(Orientation newOrientation) {
		return new LawnMower(coordinates, newOrientation);
	}

	Coordinates getCoordinates() {
		return coordinates;
	}

	Orientation getOrientation() {
		return orientation;
	}

	@Override
	public String toString() {
		return coordinates + " " + orientation;
	}

	private LawnMower(Coordinates coordinates, Orientation orientation) {
		this.coordinates = coordinates;
		this.orientation = orientation;
	}

	private Coordinates coordinates;
	private Orientation orientation;
	
}
