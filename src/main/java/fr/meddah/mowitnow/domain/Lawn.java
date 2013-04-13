package fr.meddah.mowitnow.domain;

import com.google.common.collect.Range;
import com.google.common.collect.Ranges;

import static java.lang.Integer.*;

public class Lawn {

	public static Lawn buildLawn(String lawn) {
		String[] upperRightCorner = lawn.split(" ");
		return new Lawn(parseInt(upperRightCorner[0]), parseInt(upperRightCorner[1]));
	}

	boolean contains(Coordinates coordinates) {
		return xRange.contains(coordinates.getX()) && yRange.contains(coordinates.getY());
	}

	private Lawn(int x, int y) {
		xRange = Ranges.closed(0, x);
		yRange = Ranges.closed(0, y);
	}
	private final Range<Integer> xRange, yRange;

}