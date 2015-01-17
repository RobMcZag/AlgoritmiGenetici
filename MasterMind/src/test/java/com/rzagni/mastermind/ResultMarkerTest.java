package com.rzagni.mastermind;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class ResultMarkerTest {

	public ResultMarkerTest() {
	}

	/* Just for my understanding of enums*/
	@Ignore @Test
	public void testEqualityAndDifference() {
		assertTrue(ResultMarker.BLACK == ResultMarker.BLACK);
		assertFalse(ResultMarker.BLACK == ResultMarker.WHITE);
	}

	/* Just for my understanding of enums*/
	@Ignore @Test
	public void testValues() {
		assertEquals(0, ResultMarker.EMPTY.ordinal());
		assertEquals("EMPTY", ResultMarker.EMPTY.name());
		assertEquals(ResultMarker.EMPTY, ResultMarker.valueOf("EMPTY"));
	}
}
