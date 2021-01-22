package springmain.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class StatefulServiceTest {

  @Test
  public void statefulServiceSingleton() {
    ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
    StatefulService service1 = ac.getBean(StatefulService.class);
    StatefulService service2 = ac.getBean(StatefulService.class);

    int userAPrice = service1.order("A", 10000);
    int user2APrice = service2.order("B", 20000);

    System.out.println(userAPrice);
    System.out.println(user2APrice);
  }

  static class TestConfig {
    @Bean
    public StatefulService statefulService() {
      return new StatefulService();
    }
  }
}
