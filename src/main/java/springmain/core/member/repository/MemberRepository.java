package springmain.core.member.repository;

import springmain.core.member.Member;

public interface MemberRepository {

  void save(Member member);

  Member findById(Long memberId);

}
