package fr.meddah.mowitnow;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.google.common.base.Charsets;

import static com.google.common.collect.Lists.*;

import static com.google.common.io.Files.*;
import static fr.meddah.mowitnow.Garden.*;

public class Main {

	public static void main(String[] args) throws IOException {
		List<String> lines = readLines(new File(args[0]), Charsets.UTF_8);

		String lawn = lines.remove(0);
			System.out.println(lawnMower(initialState).mowing(lawn).with(instructions).getFinalState());
		for (List<String> lawnMowerConfiguration : partition(lines, 2)) {
			String initialState = lawnMowerConfiguration.get(0);
			String instructions = lawnMowerConfiguration.get(1);
		}
	}
}