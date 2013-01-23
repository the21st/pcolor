package de.fhg.igd.pcolor.test;

import static org.junit.Assert.*;

import org.junit.Test;

import de.fhg.igd.pcolor.sRGB;

public class CheckTest {

	@Test
	public void testisInRange() {
		assertTrue(new sRGB(0.736f, 0.237f, 0.946f).isInRange(0, 0));
		assertTrue(new sRGB(1f, 1f, 1f).isInRange(0, 0));
		assertTrue(new sRGB(0f, 0f, 0f).isInRange(0, 0));
		
		assertFalse(new sRGB(0.736f, 1.237f, 0.946f).isInRange(0, 0));
		assertTrue(new sRGB(0.736f, 1.237f, 0.946f).isInRange(0, 0.25f));
		
		assertFalse(new sRGB(-0.1f, 0.237f, 0.946f).isInRange(0, 0));
		assertTrue(new sRGB(-0.1f, 0.237f, 0.946f).isInRange(0.1f, 0));
		assertTrue(new sRGB(-0.1f, 1.237f, 0.946f).isInRange(0.1f, 0.25f));
		assertFalse(new sRGB(-0.1f, 1.237f, 0.946f).isInRange(0, 0));
	}
	
	@Test
	public void testOutOfRange() {
		assertEquals(0.1, new sRGB(1.1f, 0.237f, 0.946f).outOfSpace(0, 0)[0], 0.0001);
		assertEquals(0.0, new sRGB(1.1f, 0.237f, 0.946f).outOfSpace(0, 0.1f)[0], 0.0001);
		
		assertEquals(-0.1, new sRGB(-0.1f, 0.237f, 0.946f).outOfSpace(0, 0)[0], 0.0001);
		assertEquals(0.0, new sRGB(-0.1f, 0.237f, 0.946f).outOfSpace(0.1f, 0)[0], 0.0001);
	}

}
