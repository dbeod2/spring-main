package springmain.core.member.service;

import springmain.core.member.Member;

public interface MemberService {
  void join(Member member);

  Member findById(Long memberId);
}
