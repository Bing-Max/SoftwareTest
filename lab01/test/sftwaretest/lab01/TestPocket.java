package sftwaretest.lab01;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestPocket {
	
	public int goal;
	public Pocket pocket;
	
	public TestPocket(int goal) {
		super();
		this.goal = goal;
	}

	@Before
	public void init() {
		pocket = new Pocket();
		pocket.init();
	}
	
	@Parameters
	public static Collection<Object[]> setData(){
		return Arrays.asList(new Object[][] {
//			{-1},
			{0},
			{2},
			{8},
			{9},
			{10},
			{25},
			{68}
		});
	}
	
	
	@Test
	public void test() {
//		assertTrue(pocket.getCombination(goal));
		pocket.getCombination(goal);
		System.out.println(Arrays.toString(pocket.getCombinationScheme()));
	}
}
