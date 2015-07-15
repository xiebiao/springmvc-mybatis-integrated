package test.testngVsJunit.junit;

import org.junit.runners.model.Statement;

/**
 * @author <a href="mailto:joyrap@qq.com">joyrap@qq.com</a>
 * @date 7/15/15
 */
public class MyStatement extends Statement {
  private Statement statement;

  public MyStatement(Statement statement) {
    this.statement = statement;
  }

  @Override
  public void evaluate() throws Throwable {
    System.out.println("evaluate before");
    statement.evaluate();
    System.out.println("evaluate after");
  }
}
