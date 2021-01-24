package springmain.core.order.service;

import springmain.core.discount.DiscountPolicy;
import springmain.core.member.Member;
import springmain.core.member.repository.MemberRepository;
import springmain.core.order.Order;

public class OrderServiceImpl implements OrderService {

  private final MemberRepository memberRepository;
  private final DiscountPolicy discountPolicy;

  public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
    this.memberRepository = memberRepository;
    this.discountPolicy = discountPolicy;
  }

  @Override
  public Order createOrder(Long memberId, String itemName, int itemPrice) {
    Member member = memberRepository.findById(memberId);
    int discountPrice = discountPolicy.discount(member, itemPrice);
    return new Order(memberId, itemName, itemPrice, discountPrice);
  }

  public MemberRepository getMemberRepository() {
    return memberRepository;
  }
}
