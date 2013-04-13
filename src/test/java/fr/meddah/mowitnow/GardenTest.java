package fr.meddah.mowitnow;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Test;
import org.junit.runner.RunWith;

import static fr.meddah.mowitnow.Garden.*;
import static org.fest.assertions.Assertions.*;

@RunWith(JUnitParamsRunner.class)
public class GardenTest {

	@Test
	@Parameters({ "0 0 N | 0 1 N", //
			"1 0 N | 1 1 N", //
			"0 0 E | 1 0 E", //
			"1 1 W | 0 1 W", //
			"1 1 S | 1 0 S" })
	public void advance_once(String initialState, String expectedState) {
		assertThat(lawnMower(initialState).mowing("1 1").with("A").getFinalState()).isEqualTo(expectedState);
	}

	@Test
	@Parameters({ "0 0 N | AA | 0 2 N", //
			"0 0 E | AAA | 3 0 E" })
	public void advance_multiple_times(String initialState, String instructions, String expectedState) {
		assertThat(lawnMower(initialState).mowing("3 3").with(instructions).getFinalState()).isEqualTo(expectedState);
	}

	@Test
	@Parameters({ "0 0 N | G | 0 0 W", //
			"0 0 N | D | 0 0 E", //
			"0 0 N | DG | 0 0 N", //
			"0 0 N | GGGG | 0 0 N" })
	public void orient_mower(String initialState, String instructions, String expectedState) {
		assertThat(lawnMower(initialState).mowing("0 0").with(instructions).getFinalState()).isEqualTo(expectedState);
	}

	@Test
	@Parameters({ "0 1 N | A | 0 1 N", //
			"0 1 W | A | 0 1 W" })
	public void stay_inside_lawn(String initialState, String instructions, String expectedState) {
		assertThat(lawnMower(initialState).mowing("1 1").with(instructions).getFinalState()).isEqualTo(expectedState);
	}

	@Test
	@Parameters({ "1 2 N | GAGAGAGAA | 1 3 N",//
			"3 3 E | AADAADADDA | 5 1 E" })
	public void examples(String initialState, String instructions, String expectedState) {
		assertThat(lawnMower(initialState).mowing("5 5").with(instructions).getFinalState()).isEqualTo(expectedState);
	}

}