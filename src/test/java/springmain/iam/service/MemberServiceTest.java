package springmain.iam.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import springmain.iam.member.Grade;
import springmain.iam.member.Member;
import springmain.iam.member.service.MemberService;
import springmain.iam.member.service.MemberServiceImpl;

public class MemberServiceTest {

  MemberService memberService = new MemberServiceImpl();

  @Test
  void join() {
    //given
    Member member = new Member(1L, "memberA", Grade.VIP);

    //when
    memberService.join(member);
    Member findMember = memberService.findById(1L);

    //then
    Assertions.assertThat(member).isEqualTo(findMember);
  }
}
