package test.testngVsJunit.junit;

import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

/**
 * @author <a href="mailto:joyrap@qq.com">joyrap@qq.com</a>
 * @date 7/15/15
 */
public class MyRule implements MethodRule {
  @Override
  public Statement apply(Statement base, FrameworkMethod method, Object target) {
    //System.out.println(target.getClass().getName());
    //System.out.println(method.getName());
    //System.out.println(base.getClass().getName());
    return new MyStatement(base);
  }
}
