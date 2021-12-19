package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

    /**
     * @Configuration은 싱글톤을 보장해준다.
     * 실제론 AppCofig를 상속받은 AppConfig@CGLIB(바이트코드가 조작)을 스프링 컨테이너에 저장한다.
     * AppConfig에서 Repositoryf를 3번 생성하는 자바코드임에도 실제론 하나의 인스턴스만 생성하게 고유할 수 있도록 해준다.
     */

    @Test
    void configurationTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        // 테스트를 위해서 구현체로 빈 가져오기
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);

        // 각 서비가 의존하는 리파지토리
        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        AppConfig bean = ac.getBean(AppConfig.class);
        System.out.println("bean = " + bean.getClass());    // AppConfig@CGLIB

        // 동일한 빈을 사용하는지 확인
        Assertions.assertThat(memberRepository1).isSameAs(memberRepository2);

    }
}
