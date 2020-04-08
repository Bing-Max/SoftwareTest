import static org.junit.Assert.assertTrue;

import java.util.Arrays;
//import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class testBubbleSort {
	private BubbleSort bs;
	
	@Before
	public void setUp() {
		bs = new BubbleSort();
	}
	
	@After
	public void relese() {
		bs = null;
	}
	
	@Test
	public void test1() {
		int[] testArr = {1,6,2,2,5};
							
		int[] testRes = {1,2,2,5,6};
				
		bs.BubbleSort(testArr);
		
		assertTrue(Arrays.equals(testArr,testRes));
	}
	@Test
	public void test2() {
		int[] testArr ={1,-6,2,7};
		int[] testRes = {-6,1,2,7};
		
		bs.BubbleSort(testArr);
		
		assertTrue(Arrays.equals(testArr,testRes));
	}
	@Test
	public void test3() {
		int[] testArr = {0,-6,2,5,3,7};
		
		
		int[] testRes = {-6,0,2,3,5,7};
		
		bs.BubbleSort(testArr);
		
		assertTrue(Arrays.equals(testArr,testRes));
	}
	@Test
	public void test4() {
		int[] testArr = {0};
		
		
		int[] testRes = {0};
		
		bs.BubbleSort(testArr);
		
		assertTrue(Arrays.equals(testArr,testRes));
	}
}
