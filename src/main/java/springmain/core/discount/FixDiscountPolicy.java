package springmain.core.discount;

import springmain.core.member.Grade;
import springmain.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

  private int discountFixAmount = 1000;

  @Override
  public int discount(Member member, int price) {
    if (member.getGrade() == Grade.VIP) {
      return discountFixAmount;
    }
    return 0;
  }
}
