package springmain.core.member.service;

import springmain.core.member.Member;
import springmain.core.member.repository.MemberRepository;

public class MemberServiceImpl implements MemberService {
  private final MemberRepository memberRepository;

  public MemberServiceImpl(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  @Override
  public void join(Member member) {
    memberRepository.save(member);
  }

  @Override
  public Member findById(Long memberId) {
    return memberRepository.findById(memberId);
  }

  public MemberRepository getMemberRepository() {
    return memberRepository;
  }
}
