package springmain.xml;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import springmain.core.member.service.MemberService;

import static org.assertj.core.api.Assertions.assertThat;

public class XmlAppContext {

  @Test
  public void xmlAppContext() {
    ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
    MemberService memberService = ac.getBean("memberService", MemberService.class);
    assertThat(memberService).isInstanceOf(MemberService.class);
  }
}
