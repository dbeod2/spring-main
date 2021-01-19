package springmain.core.order.service;

import springmain.core.discount.DiscountPolicy;
import springmain.core.discount.FixDiscountPolicy;
import springmain.core.member.Member;
import springmain.core.member.repository.MemberRepository;
import springmain.core.member.repository.MemoryMemberRepository;
import springmain.core.order.Order;

public class OrderServiceImpl implements OrderService {

  private final MemberRepository memberRepository = new MemoryMemberRepository();
  private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

  @Override
  public Order createOrder(Long memberId, String itemName, int itemPrice) {
    Member member = memberRepository.findById(memberId);
    int discountPrice = discountPolicy.discount(member, itemPrice);
    return new Order(memberId, itemName, itemPrice, discountPrice);
  }
}
