package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인")
    void VIP_o(){
        // given
        Member memberVIP = new Member(1L, "memberVIP", Grade.VIP);
        // when
        int discountPrice = discountPolicy.discount(memberVIP, 10000);
        // then
        assertThat(discountPrice).isEqualTo(1000);  // static import로 메소드만 사용
    }

    @Test
    @DisplayName("BASIC은 10% 할인 적용x")
    void VIP_x(){
        Member memberBASIC = new Member(1L, "memberBASIC", Grade.BASIC);
        int discountPrice = discountPolicy.discount(memberBASIC, 10000);

        assertThat(discountPrice).isEqualTo(0);
    }
}