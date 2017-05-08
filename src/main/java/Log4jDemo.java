import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jDemo {
	
	private static Logger log = LogManager.getLogger();

	public static void main(String[] args) {
		log.debug("====log4j: debug");  
        log.info("====log4j: info");  
        log.warn("====log4j: warn");  
        log.error("====log4j: error");  
        log.fatal("====log4j: fatal");

	}

}
