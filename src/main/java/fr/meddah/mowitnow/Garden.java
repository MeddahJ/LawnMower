package fr.meddah.mowitnow;

import java.util.List;

import fr.meddah.mowitnow.domain.Lawn;
import fr.meddah.mowitnow.domain.LawnMower;

import static com.google.common.collect.Lists.*;
import static fr.meddah.mowitnow.domain.Instruction.*;
import static fr.meddah.mowitnow.domain.Lawn.*;
import static fr.meddah.mowitnow.domain.LawnMower.*;

public class Garden {

	static GardenLawnMower forLawnMower(String initialState) {
		return new GardenLawnMower(buildLawnMower(initialState));
	}

	static class GardenLawnMower {
		GardenLawn mowing(String lawn) {
			return new GardenLawn(buildLawn(lawn));
		}

		class GardenLawn {
			LawnMowerInstructions following(String instructions) {
				return new LawnMowerInstructions(charactersOf(instructions));
			}

			class LawnMowerInstructions {
				String getFinalPosition() {
					LawnMower currentLawnMower = lawnMower;
					for (Character instruction : instructions) {
						currentLawnMower = from(instruction).execute(currentLawnMower, lawn);
					}
					return currentLawnMower.toString();
				}

				private LawnMowerInstructions(List<Character> instructions) {
					this.instructions = instructions;
				}

				private List<Character> instructions;
			}

			private GardenLawn(Lawn lawn) {
				this.lawn = lawn;
			}

			private Lawn lawn;
		}

		private GardenLawnMower(LawnMower lawnMower) {
			this.lawnMower = lawnMower;
		}

		private LawnMower lawnMower;
	}
}
