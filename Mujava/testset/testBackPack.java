import static org.junit.Assert.assertTrue;

import java.util.Arrays;
// import java.util.Collection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.junit.runners.Parameterized;
// import org.junit.runners.Parameterized.Parameters;

// @RunWith(Parameterized.class)
public class testBackPack {
	private BackPack bk;
	@Before
	public void setUp(){
		bk = new BackPack();
	}

	@After
	public void release(){
		bk = null;
	}
	@Test
	public void testBackPack() {
		int m = 10;
		int[] w = {3,4,5};
		int[] v = {4,5,6};
		int[][] c = {{0,0,0,0,0,0,0,0,0,0,0},
					 {0,0,0,4,4,4,4,4,4,4,4},
					 {0,0,0,4,5,5,5,9,9,9,9},
					 {0,0,0,4,5,6,6,9,10,11,11}};
		int[][] res = bk.BackPack_Solution(m, w.length, w, v);
		for(int i = 0; i < w.length+1; i++) {
			assertTrue(Arrays.equals(res[i], c[i]));
			System.out.println(Arrays.toString(res[i]));
		}
	}
}
