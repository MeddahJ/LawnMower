package fr.meddah.mowitnow.domain;

class Coordinates {

	Coordinates addTo(Coordinates other) {
		return new Coordinates(x + other.x, y + other.y);
	}

	@Override
	public String toString() {
		return x + " " + y;
	}

	int getX() {
		return x;
	}

	int getY() {
		return y;
	}

	Coordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}

	private final int x, y;
}