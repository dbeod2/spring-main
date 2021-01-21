package springmain.beanfind;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springmain.core.AppConfig;

import java.util.Arrays;

public class ApplicationContextInfoTest {

  AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

  @Test
  @DisplayName("모든 빈 출력")
  public void findAllBean() {
    String[] beanDefinitionNames = ac.getBeanDefinitionNames();
    Arrays.stream(beanDefinitionNames)
            .map(e -> "name : " + e + "," + "object:" + ac.getBean(e))
            .forEach(System.out::println);
  }


  @Test
  @DisplayName("애플리케이션 빈 출력")
  public void findApplicationBean() {
    String[] beanDefinitionNames = ac.getBeanDefinitionNames();
    // ROLE_APPLICATION : 직접 등록한 어플리케이션 빈
    // ROLE_INFRASTRUCTURE : 스프링이 내부에서 사용하는 빈
    Arrays.stream(beanDefinitionNames)
            .filter(beanDefinitionName -> isRole(ac.getBeanDefinition(beanDefinitionName)))
            .map(beanDefinitionName ->
                    String.format("name : %s, object :%s", beanDefinitionName, ac.getBean(beanDefinitionName)))
            .forEach(System.out::println);
  }

  private boolean isRole(BeanDefinition beanDefinition) {
    return beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION;
  }
}
