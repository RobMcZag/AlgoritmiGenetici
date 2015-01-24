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
		assertEquals(2, ResultMarker.EMPTY.ordinal());
		assertEquals("EMPTY", ResultMarker.EMPTY.name());
		assertEquals(ResultMarker.EMPTY, ResultMarker.valueOf("EMPTY"));
	}
	
	@Test(expected=NullPointerException.class)
	public void testCountResultMarkers_NullArray() {
		ResultMarker.countResultMarkers(null);
		fail("Should throw a NullPointerException if the array is a null.");
	}
	@Test(expected=NullPointerException.class)
	public void testCountResultMarkers_NullValues() {
		ResultMarker.countResultMarkers(
				new ResultMarker[] {ResultMarker.EMPTY, null, ResultMarker.EMPTY, ResultMarker.EMPTY});
		fail("Should throw a NullPointerException if there is a null in the values of the array.");
	}
	@Test
	public void testCountResultMarkers() {
		int [] res = ResultMarker.countResultMarkers(
				new ResultMarker[] {ResultMarker.EMPTY, ResultMarker.EMPTY, ResultMarker.EMPTY});
		assertEquals(0, res[ResultMarker.BLACK.ordinal()]);
		assertEquals(0, res[ResultMarker.WHITE.ordinal()]);
		assertEquals(3, res[ResultMarker.EMPTY.ordinal()]);

		res = ResultMarker.countResultMarkers(
				new ResultMarker[] {ResultMarker.BLACK, ResultMarker.WHITE, ResultMarker.EMPTY});
		assertEquals(1, res[ResultMarker.BLACK.ordinal()]);
		assertEquals(1, res[ResultMarker.WHITE.ordinal()]);
		assertEquals(1, res[ResultMarker.EMPTY.ordinal()]);

		res = ResultMarker.countResultMarkers(
				new ResultMarker[] {ResultMarker.BLACK, ResultMarker.WHITE, ResultMarker.EMPTY, ResultMarker.EMPTY});
		assertEquals(1, res[ResultMarker.BLACK.ordinal()]);
		assertEquals(1, res[ResultMarker.WHITE.ordinal()]);
		assertEquals(2, res[ResultMarker.EMPTY.ordinal()]);

		res = ResultMarker.countResultMarkers(
				new ResultMarker[] {ResultMarker.BLACK, ResultMarker.WHITE, ResultMarker.EMPTY, ResultMarker.BLACK});
		assertEquals(2, res[ResultMarker.BLACK.ordinal()]);
		assertEquals(1, res[ResultMarker.WHITE.ordinal()]);
		assertEquals(1, res[ResultMarker.EMPTY.ordinal()]);

		res = ResultMarker.countResultMarkers(
				new ResultMarker[] {ResultMarker.BLACK, ResultMarker.WHITE, ResultMarker.BLACK, ResultMarker.EMPTY, ResultMarker.BLACK});
		assertEquals(3, res[ResultMarker.BLACK.ordinal()]);
		assertEquals(1, res[ResultMarker.WHITE.ordinal()]);
		assertEquals(1, res[ResultMarker.EMPTY.ordinal()]);
	}
	
}
