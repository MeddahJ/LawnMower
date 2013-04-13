package fr.meddah.mowitnow.domain;

enum Orientation {
	N(0, 1), E(1, 0), S(0, -1), W(-1, 0);

	Coordinates getRelativeCoordinates() {
		return relativeCoordinates;
	}

	Orientation turnLeft() {
		return turn(COUNTER_CLOCKWISE);
	}

	Orientation turnRight() {
		return turn(CLOCKWISE);
	}

	private Orientation turn(int n) {
		int directions = Orientation.values().length;
		return Orientation.values()[(directions + ordinal() + n ) % directions];
	}

	private Orientation(int x, int y) {
		this.relativeCoordinates = new Coordinates(x, y);
	}

	private final Coordinates relativeCoordinates;

	private static final int CLOCKWISE = 1,
							 COUNTER_CLOCKWISE = -1;
}