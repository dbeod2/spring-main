package springmain.iam.member.repository;

import springmain.iam.member.Member;

public interface MemberRepository {

  void save(Member member);

  Member findById(Long memberId);

}
