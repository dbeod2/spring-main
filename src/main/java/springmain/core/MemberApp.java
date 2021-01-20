package springmain.core;

import springmain.core.member.Grade;
import springmain.core.member.Member;
import springmain.core.member.repository.MemoryMemberRepository;
import springmain.core.member.service.MemberService;
import springmain.core.member.service.MemberServiceImpl;

public class MemberApp {

  public static void main(String[] args) {
    MemberService memberService = new MemberServiceImpl(new MemoryMemberRepository());
    Member member = new Member(1L, "memberA", Grade.VIP);
    memberService.join(member);

    Member findMember = memberService.findById(1L);
    System.out.println("new Member :" + member.getName());
    System.out.println("find Member :" + findMember.getName());
  }
}
