import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import cn.yxy.daoImpl.StuDAOImpl;

public class StuDAOImplTest {
		@Test
		public void teatmain(){
			StuDAOImpl sdi=new StuDAOImpl();
			assertTrue(sdi.updateByID(10,null));
			assertTrue(sdi.deleteByID(12));
			assertNotNull(sdi.getByID(3));
			assertNotEquals(0,sdi.insert(null));
		}
	
}
