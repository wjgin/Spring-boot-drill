package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.assertj.core.api.Assertions.*;

public class StatefulServiceTest {

    @Test
    @DisplayName("유지 상태의 문제점")
    void statefulServiceTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);

        // Thread A : 사용자 A가 10000원 주문
        int userAPrice = statefulService1.order("userA", 10000);
        // Thread B : 사용자 B가 20000원 주문
        int userBPrice = statefulService2.order("userB", 20000);

        // 사용자 A의 주문금액 조회
        // int price = statefulService1.getPrice();

        // 하나의 인스턴스를 사용하여 B의 주문정보로 교체됨
        // assertThat(price).isEqualTo(20000);

        // 무상태를 위해서 지역변수로 저장시킴
        assertThat(userAPrice).isEqualTo(10000);
    }

    @Configuration
    static class TestConfig{

        @Bean
        StatefulService statefulService(){
            return new StatefulService();
        }

    }

}
