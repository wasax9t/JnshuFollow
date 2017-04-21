
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SmallTest {
	String sos="ALL DONE";
	String s1="ALL";
	
	@Test
	public void testStrAdd(){
		assertEquals(sos,s1+" DONE");
	}
}
