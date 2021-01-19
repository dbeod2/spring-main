package springmain.iam.member.service;

import springmain.iam.member.Member;
import springmain.iam.member.repository.MemberRepository;
import springmain.iam.member.repository.MemoryMemberRepository;

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
