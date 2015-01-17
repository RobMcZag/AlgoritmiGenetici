package com.rzagni.mastermind;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PegTest {
	
	private Integer color1 = 1;
	private Peg<Integer> p1 = new Peg<Integer>(color1);
	private Peg<Integer> p1bis = new Peg<Integer>(color1);
	private Integer color2 = 2;
	private Peg<Integer> p2 = new Peg<Integer>(color2);
	
	private String colorR = "R";
	private Peg<String> pr = new Peg<String>(colorR);
	private Peg<String> prbis = new Peg<String>(colorR);
	private String colorG = "g";
	private Peg<String> pg = new Peg<String>(colorG);

	private ResultMarker colorWHITE = ResultMarker.WHITE;
	private Peg<ResultMarker> pWHITE = new Peg<ResultMarker>(colorWHITE);
	private Peg<ResultMarker> pWHITEbis = new Peg<ResultMarker>(colorWHITE);
	private ResultMarker colorBLACK = ResultMarker.BLACK;
	private Peg<ResultMarker> pBLACK = new Peg<ResultMarker>(colorBLACK);
	private ResultMarker colorEMPTY = ResultMarker.EMPTY;
	private Peg<ResultMarker> pEMPTY = new Peg<ResultMarker>(colorEMPTY);


	public PegTest() {
	}

	@Before
	public void setUp() throws Exception {
		color1 = 1;
		p1 = new Peg<Integer>(color1);
		p1bis = new Peg<Integer>(color1);
		color2 = 2;
		p2 = new Peg<Integer>(color2);

		colorR = "R";
		pr = new Peg<String>(colorR);
		prbis = new Peg<String>(colorR);
		colorG = "g";
		pg = new Peg<String>(colorG);
		
		colorWHITE = ResultMarker.WHITE;
		pWHITE = new Peg<ResultMarker>(colorWHITE);
		pWHITEbis = new Peg<ResultMarker>(colorWHITE);
		colorBLACK = ResultMarker.BLACK;
		pBLACK = new Peg<ResultMarker>(colorBLACK);
		colorEMPTY = ResultMarker.EMPTY;
		pEMPTY = new Peg<ResultMarker>(colorEMPTY);
	}
	
	@Test
	public void testIntegerPegCreation() {
		assertNotNull(p1);
		assertEquals(color1, p1.getColor());
	}
	@Test
	public void testIntegerPegEquals() {
		assertTrue("I should have two different peg with same color", p1 != p1bis);
		assertEquals("The two pegs should have same color", p1, p1bis);
		
		assertNotEquals("The two pegs should have different colors", p1, p2);
	}
	
	@Test
	public void testIntegerPegHashCode() {
		assertTrue("I should have two different peg with same color", p1 != p1bis);
		assertEquals("Two different peg with same color should have same hashmap.", p1.hashCode(), p1bis.hashCode());
		
		assertNotEquals("Two peg with different color should have different hashmap.", p1.hashCode(), p2.hashCode());
	}

	@Test
	public void testDifferentTypeOfPegsCanNotMix() {
		// assertTrue(p1 != pEMPTY); /* COMPILER ENFORCE THIS */
		assertFalse("Pegs of different Type should be different", p1.equals(pBLACK));
		assertNotEquals("Pegs of different Type should be different", p1, pr);
		assertNotEquals("Pegs of different Type should have different hashcodes", p1.hashCode(), pr.hashCode());
		
		Peg px = p1;
		Peg py = pWHITE;
		assertTrue(px != py);
		assertNotEquals("Pegs of different Type should be different", px, py);
	}
	// TODO should check two different kind of pegs are not equal / mixable
	
	@Test
	public void testStringPegCreation() {
		assertNotNull(pr);
		assertEquals(colorR, pr.getColor());
	}
	@Test
	public void testStringPegEquals() {
		assertTrue("I should have two different peg with same color", pr != prbis);
		assertEquals("The two pegs should have same color", pr, prbis);
		
		assertNotEquals("The two pegs should have different colors", pr, pg);
	}
	@Test
	public void testStringPegHashCode() {
		assertTrue("I should have two different peg with same color", pr != prbis);
		assertEquals("Two different peg with same color should have same hashmap.", pr.hashCode(), prbis.hashCode());
		
		assertNotEquals("Two peg with different color should have different hashmap.", pr.hashCode(), pg.hashCode());
	}

	@Test
	public void testEnumPegCreation() {
		assertNotNull(pWHITE);
		assertEquals(colorWHITE, pWHITE.getColor());
	}
	@Test
	public void testEnumPegEquals() {
		assertTrue("I should have two different peg with same color", pWHITE != pWHITEbis);
		assertEquals("The two pegs should have same color", pWHITE, pWHITEbis);
		
		assertNotEquals("The two pegs should have different colors", pWHITE, pBLACK);
		assertNotEquals("The two pegs should have different colors", pWHITE, pEMPTY);
	}
	@Test
	public void testEnumPegHashCode() {
		assertTrue("I should have two different peg with same color", pWHITE != pWHITEbis);
		assertEquals("Two different peg with same color should have same hashmap.", pWHITE.hashCode(), pWHITEbis.hashCode());
		
		assertNotEquals("Two peg with different color should have different hashmap.", pWHITE.hashCode(), pBLACK.hashCode());
		assertNotEquals("Two peg with different color should have different hashmap.", pWHITE.hashCode(), pEMPTY.hashCode());
	}

}
