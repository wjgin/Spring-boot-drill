package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

// @Component  // Bean 등록 방법 중, 하나, Configuration에서 등록 가능
@Aspect
public class TimeTraceAop {

    // @Around("execution(* hello.hellospring..*(..))")
    // config에서 Bean 등록시 순환 참조가 일어나지 않게 configuration class는 제외
    @Around("execution(* hello.hellospring..*(..)) && !target(hello.hellospring.SpringConfig)")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();

        System.out.println("START: " + joinPoint.toString());   // 실행하는 메소드 이름 콜

        try{
            return joinPoint.proceed(); // 다음 메소드 진행
        } finally {
            long finish = System.currentTimeMillis();
            long time = finish - start;

            System.out.println("END: " + finish + " " + time + "ms");
        }
    }
}
