package GAtest;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import GA.*;

public class EvoloveTest {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetIndividual() {
		Evolove e = new Evolove();
		e.readGoods();
		int[] test = e.getIndividualCode();
		assertEquals(40, test.length);
//		fail("Not yet implemented");
	}
	
	@Test
	public void testCross() {
		Evolove e = new Evolove();
		int[] fir = {1,0,1,0,1,1,0,1,1,0,1};
		int[] sec = {1,1,0,1,0,1,0,0,1,0,0};
		int[] firCopy = new int[fir.length];
		for(int i = 0; i < fir.length;i++) {
			fir[i] = firCopy[i];
		}
		
		e.cross(fir, sec);
		assertNotEquals(fir, firCopy);
//		fail("Not yet implemented");
	}
	
	@Test
	public void testVariate() {
		Evolove e = new Evolove();
		int[] fir ={1,0,1,0,1,1,0,1,1,0,1};
		int[] firCopy = new int[fir.length];
		for(int i = 0; i < fir.length;i++) {
			fir[i] = firCopy[i];
		}
		assertNotEquals(e.Variate(fir), firCopy);
//		fail("Not yet implemented");
	}
	
}
