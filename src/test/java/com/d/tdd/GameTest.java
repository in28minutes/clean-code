package com.d.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

//0 20
//1 20
//1 10 2 10
// spare 5,5 1 18

class GameTest {

	Game game = new Game();

	@Test
	void testAll0s() {

		rollMultipleTimes(0, 20);

		assertEquals(0, game.score());
	}

	@Test
	void testAll1s() {

		rollMultipleTimes(1, 20);

		assertEquals(20, game.score());
	}

	@Test
	void testHalf1sAndHalf2s() {

		rollMultipleTimes(1, 10);
		rollMultipleTimes(2, 10);

		assertEquals(30, game.score());
	}

	@Test
	void testSpare() {

		rollASpare();
		rollMultipleTimes(1, 18);

		assertEquals(29, game.score());
	}

	@Test
	void testTwoSpares() {

		rollASpare();
		rollASpare();
		rollMultipleTimes(1, 16);
		
		assertEquals(42, game.score());
	}
	
	@Test
	void testStrike() {
		game.roll(10);
		rollMultipleTimes(1, 18);
		assertEquals(30, game.score());
	}


	private void rollASpare() {
		rollMultipleTimes(5, 2);
	}

	private void rollMultipleTimes(int pinsKnockedDown, int noOfTimes) {
		for (int i = 1; i <= noOfTimes; i++)
			game.roll(pinsKnockedDown);
	}

}

//Red
//Green
//Refactor
