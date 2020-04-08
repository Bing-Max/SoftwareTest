import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;

public class testAdd {
	private Add add;
	@Before
	public void setUp(){
		add = new Add();
	}

	@After
	public void release(){
		add = null;
	}

	@Test
	public void test() {
		assertEquals(3, add.add(1, 2));
	}
}
