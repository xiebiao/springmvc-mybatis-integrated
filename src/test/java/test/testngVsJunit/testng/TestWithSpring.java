package test.testngVsJunit.testng;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * @author <a href="mailto:joyrap@qq.com">joyrap@qq.com</a>
 * @date 7/14/15
 */
@Test
@ContextConfiguration(locations = {"classpath:spring/spring-config.xml"})
public class TestWithSpring extends AbstractTestNGSpringContextTests {

}
