
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cn.yxy.daoImpl.MySQLUnit;


public class MySQLUnitTest {
	
	@Test
	public void teatmain(){
		MySQLUnit mb=new MySQLUnit();
		assertTrue(mb.initConn());
		assertTrue(mb.closeConn());
	}
}
