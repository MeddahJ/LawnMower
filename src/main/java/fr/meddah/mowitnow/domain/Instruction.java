package fr.meddah.mowitnow.domain;

public enum Instruction {
	A {
		@Override
		public LawnMower execute(LawnMower lawnMower, Lawn lawn) {
			Coordinates futureCoordinates = lawnMower.getCoordinates().addTo(lawnMower.getOrientation().getRelativeCoordinates());
			return lawn.contains(futureCoordinates) ? lawnMower.withNewCoordinates(futureCoordinates) : lawnMower;
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