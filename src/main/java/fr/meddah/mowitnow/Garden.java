package fr.meddah.mowitnow;

import java.util.List;

import fr.meddah.mowitnow.domain.Lawn;
import fr.meddah.mowitnow.domain.LawnMower;

import static com.google.common.collect.Lists.*;
import static fr.meddah.mowitnow.domain.Instruction.*;
import static fr.meddah.mowitnow.domain.Lawn.*;
import static fr.meddah.mowitnow.domain.LawnMower.*;

public class Garden implements GardenLawnMower, GardenLawn, GardenLawnMowerInstruction {

	static GardenLawnMower forLawnMower(String initialState) {
		Garden garden = new Garden();
		garden.lawnMower = buildLawnMower(initialState);
		return garden;
	}

	public GardenLawn mowing(String lawn) {
		this.lawn = buildLawn(lawn);
		return this;
	}

	public GardenLawnMowerInstruction following(String instructions) {
		this.instructions = charactersOf(instructions);
		return this;
	}

	public String getFinalPosition() {
		LawnMower currentLawnMower = lawnMower;
		for (Character instruction : instructions) {
			currentLawnMower = from(instruction).execute(currentLawnMower, lawn);
		}
		return currentLawnMower.toString();
	}

	private Garden(){}

	private LawnMower lawnMower;
	private Lawn lawn;
	private List<Character> instructions;
}

interface GardenLawnMower {
	GardenLawn mowing(String lawn);
}

interface GardenLawn {
	GardenLawnMowerInstruction following(String instructions);
}

interface GardenLawnMowerInstruction {
	String getFinalPosition();
}