package fr.meddah.mowitnow;

import java.util.List;

import fr.meddah.mowitnow.domain.Instruction;
import fr.meddah.mowitnow.domain.Lawn;
import fr.meddah.mowitnow.domain.LawnMower;
import static fr.meddah.mowitnow.domain.Lawn.*;
import static fr.meddah.mowitnow.domain.LawnMower.*;
import static java.util.Arrays.*;

public class Garden {

	static GardenLawnMower lawnMower(String initialState) {
		return new GardenLawnMower(buildLawnMower(initialState));
	}

	static class GardenLawnMower {
		GardenLawn mowing(String lawn) {
			return new GardenLawn(buildLawn(lawn));
		}

		class GardenLawn {
			LawnMowerIntructions with(String instructions) {
				return new LawnMowerIntructions(lettersOf(instructions));
			}

			class LawnMowerIntructions {
				String getFinalState() {
					LawnMower currentLawnMower = lawnMower;
					for (String instruction : instructions) {
						currentLawnMower = Instruction.valueOf(instruction).execute(currentLawnMower, lawn);
					}
					return currentLawnMower.toString();
				}

				private LawnMowerIntructions(List<String> instructions) {
					this.instructions = instructions;
				}

				private List<String> instructions;
			}

			private List<String> lettersOf(String instructionSequence) {
				return asList(instructionSequence.split("(?<!^)"));// Split on empty string but discards the first empty result
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
