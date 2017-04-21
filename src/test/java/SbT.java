
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cn.spring.daoImpl.Mysqlbasic;


public class SbT {
	
	@Test
	public void teatmain(){
		Mysqlbasic mb=new Mysqlbasic();
		assertTrue(mb.initConn());
		assertTrue(mb.closeConn());
	}
}
