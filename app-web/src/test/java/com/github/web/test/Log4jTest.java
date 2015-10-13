package com.github.web.test;



import org.junit.Test;
import org.slf4j.LoggerFactory;

/**
 * Created by xiebiao on 2015/10/13.
 */
public class Log4jTest {
    private static org.slf4j.Logger logger= LoggerFactory.getLogger("MY-XXX-LOG");
    @Test
    public void test_logger_additivity(){
        logger.debug("test");
    }
}
