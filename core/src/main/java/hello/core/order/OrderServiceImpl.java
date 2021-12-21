package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    /**
     * 변화된 할인 정책으로 인해서(기능의 확장) 클라이언트 서비스인 OderServiceImpl의 코드를 변경 하였다(OCP 위반)
     * OrderServiceImpl읜 추상화된 인터페이스뿐 아니라 구현체 역시 의존하고 있다.(DIP 위반)
     * */
//    DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    DiscountPolicy discountPolicy = new RateDiscountPolicy();
//    MemberRepository memberRepository = new MemoryMemberRepository();

    // AppConfig로 구체화된 객체를 주입, 서비스는 추상화에만 의존
    private final DiscountPolicy discountPolicy;
    private final MemberRepository memberRepository;

    @Autowired
    public OrderServiceImpl(DiscountPolicy discountPolicy, MemberRepository memberRepository) {
        this.discountPolicy = discountPolicy;
        this.memberRepository = memberRepository;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice); // 단일 책임 원칙으로 설계(할인에 관한건 할인 객체에서만 구성)

       return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트용
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
