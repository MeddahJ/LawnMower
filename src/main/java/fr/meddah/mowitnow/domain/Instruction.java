package fr.meddah.mowitnow.domain;

public enum Instruction {
	A {
		@Override
		public LawnMower execute(LawnMower lawnMower, Lawn lawn) {
			Coordinates futureCoordinates = lawnMower.getOrientation().getRelativeCoordinates().addTo(lawnMower.getCoordinates());
			return lawn.contains(futureCoordinates) ? lawnMower.changeCoordinates(futureCoordinates) : lawnMower;
		}
	},
	G {
		@Override
		public LawnMower execute(LawnMower lawnMower, @SuppressWarnings("unused") Lawn lawn) {
			return lawnMower.changeOrientation(lawnMower.getOrientation().leftwards());
		}
	},
	D {
		@Override
		public LawnMower execute(LawnMower lawnMower, @SuppressWarnings("unused") Lawn lawn) {
			return lawnMower.changeOrientation(lawnMower.getOrientation().rightwards());
		}
	};

	public abstract LawnMower execute(LawnMower lawnMower, Lawn lawn);
}