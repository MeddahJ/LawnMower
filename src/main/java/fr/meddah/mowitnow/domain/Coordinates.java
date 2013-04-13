package fr.meddah.mowitnow.domain;



class Coordinates {
	private final int x, y;

	Coordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}

	Coordinates addTo(Coordinates other) {
		return new Coordinates(x + other.x, y + other.y);
	}

	int getX() {
		return x;
	}

	int getY() {
		return y;
	}

	@Override
	public String toString() {
		return x + " " + y;
	}

}
