package com.rzagni.mastermind;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PegFactoryTest {

	public PegFactoryTest() {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFactoryCreation() {
		PegFactory factory = PegFactory.getInstance();
		assertNotNull("We should be able to get a factory object", factory);
		assertTrue("The factory is a singleton and should return always the same object", 
				factory == PegFactory.getInstance());
	}
	
	@Test
	public void testIntegerPegCreation() {
		Integer color1 = 1;
		PegFactory factory = PegFactory.getInstance();
		
		Peg<Integer> p = factory.getPeg(color1);
		assertNotNull("The factory should be able to create a Peg<Integer> object", p);
		
		Peg<Integer> p1 = new Peg<Integer>(color1);
		assertEquals("The factory should return a peg with the required color", p1, p);
		
		Peg<Integer> pBis = factory.getPeg(color1);
		assertEquals("The factory should return a peg with the required color", p1, pBis);
		assertTrue("The factory should return always the same Peg object for a certain colour", p == pBis);
		
		Integer color2 = 2;
		Peg<Integer> pDue = factory.getPeg(color2);
		Peg<Integer> p2 = new Peg<Integer>(color2);
		assertEquals("The factory should return a peg with the required color", p2, pDue);
		
		
	}

	@Test
	public void testStringPegCreation() {
		String colorR = "R";
		PegFactory factory = PegFactory.getInstance();
		
		Peg<String> p = factory.getPeg(colorR);
		assertNotNull("The factory should be able to create a Peg<Integer> object", p);
		
		Peg<String> p1 = new Peg<String>(colorR);
		assertEquals("The factory should return a peg with the required color", p1, p);
		
		Peg<String> pBis = factory.getPeg(colorR);
		assertEquals("The factory should return a peg with the required color", p1, pBis);
		assertTrue("The factory should return always the same Peg object for a certain colour", p == pBis);

		String colorG = "G";
		Peg<String> pDue = factory.getPeg(colorG);
		Peg<String> p2 = new Peg<String>(colorG);
		assertEquals("The factory should return a peg with the required color", p2, pDue);
}

}
