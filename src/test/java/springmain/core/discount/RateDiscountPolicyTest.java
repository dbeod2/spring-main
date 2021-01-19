package springmain.core.discount;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import springmain.core.member.Grade;
import springmain.core.member.Member;

import static org.assertj.core.api.Assertions.assertThat;

class RateDiscountPolicyTest {

  RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

  @Test
  @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
  public void vip_할인_적용() {
    Member member = new Member(1L, "memberVIP", Grade.VIP);

    int discount = discountPolicy.discount(member, 10000);

    assertThat(discount).isEqualTo(1000);
  }

  @Test
  @DisplayName("VIP가 아니면 할인되지않는다..")
  public void vip_아닌경우() {
    Member member = new Member(1L, "memberBasic", Grade.BASIC);

    int discount = discountPolicy.discount(member, 10000);

    assertThat(discount).isEqualTo(0);
  }
}