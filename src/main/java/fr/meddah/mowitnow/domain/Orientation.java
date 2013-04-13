package fr.meddah.mowitnow.domain;

enum Orientation {
	N(0, 1), E(1, 0), S(0, -1), W(-1, 0);

	Coordinates getRelativeCoordinates() {
		return relativeCoordinates;
	}

	Orientation turnLeft() {
		return turn(-1);
	}

	Orientation turnRight() {
		return turn(+1);
	}

	private Orientation turn(int n) {
		int four = Orientation.values().length;
		return Orientation.values()[(ordinal() + n + four) % four];// remainder != modulo
	}

	private Orientation(int x, int y) {
		this.relativeCoordinates = new Coordinates(x, y);
	}

	private final Coordinates relativeCoordinates;
}