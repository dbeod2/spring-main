package springmain.iam;

import springmain.iam.member.Grade;
import springmain.iam.member.Member;
import springmain.iam.member.service.MemberService;
import springmain.iam.member.service.MemberServiceImpl;

public class MemberApp {

  public static void main(String[] args) {
    MemberService memberService = new MemberServiceImpl();
    Member member = new Member(1L, "memberA", Grade.VIP);
    memberService.join(member);

    Member findMember = memberService.findById(1L);
    System.out.println("new Member :" + member.getName());
    System.out.println("find Member :" + findMember.getName());
  }
}
