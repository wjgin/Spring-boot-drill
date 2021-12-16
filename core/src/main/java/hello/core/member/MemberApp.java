package hello.core.member;

import hello.core.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {

/*
        MemberService memberService;
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
*/

        // 스프링 컨테이너(ApplicationContext) 사용하기
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class); // (이름, 타입)의 Bean을 가져오기

        Member memeber = new Member(1L, "memeberA", Grade.VIP);
        memberService.join(memeber);

        Member findMember = memberService.findMemeber(1L);

        System.out.println("new memeber = " + memeber.getName());
        System.out.println("find member = " + findMember.getName());
    }
}
