package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 애플리케이션 동작을 위한 구현 객체를 생성하는 역할을 한다.
// 역할과 구현이 한 눈에 들어오게 한다.
// 스프링 DI 컨테이너에 넣기 위해서 @Configuration을 기입
@Configuration
public class AppConfig {

    @Bean   // 스프링 컨테이너(ApplicationContext)에 메소드 이름으로 빈 생성 (name= "") 옵션으로 이름 변경 가능, 관례상 디폴트 사용
    // 생성자 주입을 통한 구체화된 객체를 결정
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public  MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    // 오더 서비스의 구체화 설정
    public OrderService orderService(){
        return new OrderServiceImpl(discountPolicy(), memberRepository());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
