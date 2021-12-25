package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void autowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(testClass.class);

    }

    // 스프링 컨테이너에 없는 빈을 Autowired하는 3가지 방법
    static class testClass{

        @Autowired(required = false)    // 필수로 가져오지 않는다.(의존관계가 없다면 메소드 자체가 호출이 안됨)
        public void setNoBean1(Member noBean1){
            System.out.println("noBean1 = " + noBean1);
        }
        @Autowired  // 없다면 null을 허용한다.
        public void setNoBean2(@Nullable Member noBean2){
            System.out.println("noBean2 = " + noBean2);
        }
        @Autowired  // java8의 Optional<>을 이용해 객체감싸 존재하지 않을 때, Optional.empty를 리턴
        public void setNoBean3(Optional<Member> noBean3){
            System.out.println("noBean3 = " + noBean3);
        }
    }
}
