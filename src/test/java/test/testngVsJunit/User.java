package test.testngVsJunit;

/**
 * @author <a href="mailto:joyrap@qq.com">joyrap@qq.com</a>
 * @date 7/14/15
 */
public class User {
  private String name;
  private int age;

  public User() {
    System.out.println("user init");
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
}
