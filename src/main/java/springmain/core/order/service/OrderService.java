package springmain.core.order.service;

import springmain.core.order.Order;

public interface OrderService {
  /**
   *
   * @return 최종 주문 결과 반환
   */
  Order createOrder(Long memberId, String itemName, int itemPrice);
}
