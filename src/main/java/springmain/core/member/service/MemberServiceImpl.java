package springmain.core.member.service;

import springmain.core.member.Member;
import springmain.core.member.repository.MemberRepository;
import springmain.core.member.repository.MemoryMemberRepository;

public class MemberServiceImpl implements MemberService {
  private final MemberRepository memberRepository = new MemoryMemberRepository();

  @Override
  public void join(Member member) {
    memberRepository.save(member);
  }

  @Override
  public Member findById(Long memberId) {
    return memberRepository.findById(memberId);
  }
}
