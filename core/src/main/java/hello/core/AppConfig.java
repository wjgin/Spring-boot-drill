package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

// 애플리케이션 동작을 위한 구현 객체를 생성하는 역할을 한다.
public class AppConfig {

    // 생성자 주입을 통한 구체화된 객체를 결정
    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    // 오더 서비스의 구체화 설정
    public OrderService orderService(){
        return new OrderServiceImpl(new FixDiscountPolicy(), new MemoryMemberRepository());
    }
}
