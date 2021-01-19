package springmain.iam.member.service;

import springmain.iam.member.Member;

public interface MemberService {
  void join(Member member);

  Member findById(Long memberId);
}
