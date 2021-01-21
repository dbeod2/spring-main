package springmain.beanfind;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springmain.core.discount.DiscountPolicy;
import springmain.core.member.repository.MemberRepository;
import springmain.core.member.repository.MemoryMemberRepository;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextSameBeanFindTest {
  AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

  @Test
  @DisplayName("타입 조회시 같은 타입이 둘 이상있으면 중복오류 발생")
  public void findByBeanTypeDuplicate() {
    assertThrows(NoUniqueBeanDefinitionException.class,
            () -> ac.getBean(MemberRepository.class));
  }

  @Test
  @DisplayName("타입 조회시 같은 타입이 둘 이상있으면 중복오류 발생, 빈 이름 지정하면 됨")
  public void findBeanByName() {
    MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);
    assertThat(memberRepository).isInstanceOf(MemberRepository.class);
  }

  @Test
  @DisplayName("특정 타입 모두 조회")
  public void findAllBeanByName() {
    Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
    beansOfType.keySet()
            .stream()
            .map(e -> "key :" + e + " , value : " + beansOfType.get(e))
            .forEach(System.out::println);
    assertThat(beansOfType.size()).isEqualTo(2);
  }

  @Configuration
  static class SameBeanConfig {

    @Bean
    public MemberRepository memberRepository() {
      return new MemoryMemberRepository();
    }

    @Bean
    public MemberRepository memberRepository2() {
      return new MemoryMemberRepository();
    }
  }
}
