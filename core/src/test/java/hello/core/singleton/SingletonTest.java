package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

/**
 * 스프링 없는 순수한 DI 컨테이너의 경우,
 * 웹 어플리케이션의 특성상 고객의 요청이 들어올 때마다 JVM 메모리에 객체를 계속 생성 -> 메모리 낭비
 * 헤결방안: 싱글톤 패턴
 *
 * 싱글톤 패턴의 문제점: 긴 코드, DIP, OCP 위반, 내부속성 변경의 어려움, private 생성자로 자식 클래스 생성 어려움
 * => 안티 패턴
 *
 * 스피링 컨테이너가 문제점을 해결
 * */
public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer(){
        AppConfig appConfig = new AppConfig();

        // 1조회: 호출할 때마다 객체 생성
        MemberService memberService1 = appConfig.memberService();

        // 2조회: 호출할 때마다 객체 생성
        MemberService memberService2 = appConfig.memberService();

        // 서로 다른 값을 출력
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        // assertThat(memberService1).isNotEqualTo(memberService2);
        assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 객체 생성을 확인")
    void singletonServiceTest(){
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);

        assertThat(singletonService1).isSameAs(singletonService2);

        // same: == 참조 비교
        // Equals: equals 값 비교
    }

    @Test
    @DisplayName("스피링 컨테이너 싱글론 확인")
    void springContainer(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        System.out.println("memberService1 = " + memberService2);
        System.out.println("memberService2 = " + memberService2);

        assertThat(memberService1).isSameAs(memberService2);
    }
}
