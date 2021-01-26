package springmain.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springmain.core.AppConfig;
import springmain.core.member.repository.MemberRepository;
import springmain.core.member.service.MemberServiceImpl;
import springmain.core.order.service.OrderServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;

public class ConfigurationSingletonTest {

  @Test
  @DisplayName("싱글톤 보장 확인 인스턴스인지 확인한다.")
  public void configurationTest(){
    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
    OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
    MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

    assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
    assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
  }

  @Test
  public void configurationDeep(){
    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    AppConfig bean = ac.getBean(AppConfig.class);

    System.out.println("bean : " + bean.getClass());
  }
}
