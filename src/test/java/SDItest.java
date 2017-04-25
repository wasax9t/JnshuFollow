import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import cn.yxy.daoImpl.StuDAOImpl;

public class SDItest {
		@Test
		public void teatmain(){
			StuDAOImpl sdi=new StuDAOImpl();
			assertTrue(sdi.updateStuByID(10,null));
			assertTrue(sdi.delStuByID(12));
			assertNotNull(sdi.findStuByID(3));
			assertNotEquals(0,sdi.addStu(null));
		}
	
}
