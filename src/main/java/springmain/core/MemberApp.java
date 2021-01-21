package springmain.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springmain.core.member.Grade;
import springmain.core.member.Member;
import springmain.core.member.service.MemberService;

public class MemberApp {

  public static void main(String[] args) {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

    Member member = new Member(1L, "memberA", Grade.VIP);
    memberService.join(member);

    Member findMember = memberService.findById(1L);
    System.out.println("new Member :" + member.getName());
    System.out.println("find Member :" + findMember.getName());
  }
}
