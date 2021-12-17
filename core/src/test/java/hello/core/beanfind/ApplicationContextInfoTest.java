package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력")
    void findAllBeans(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("bean = " + bean + " name = " + beanDefinitionName);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력")
    void findApplicationBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            // bean의 메타 데이터
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            /*
            * ROLE_APPLICATION: 직접 등록한 애플리케이션 빈
            * ROLE_INFRASTRUCTURE: 스프링 내부에서 사용하는 빈
           * */
            // 직접 구현한 빈일 경우만 출력
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("bean = " + bean + " name = " + beanDefinitionName);
            }
        }
    }
}
