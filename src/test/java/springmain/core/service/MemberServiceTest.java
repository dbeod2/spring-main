package springmain.core.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import springmain.core.member.Grade;
import springmain.core.member.Member;
import springmain.core.member.service.MemberService;
import springmain.core.member.service.MemberServiceImpl;

public class MemberServiceTest {

  MemberService memberService = new MemberServiceImpl(memberRepository);

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
