package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan( // @Component를 모드 스캔
        // 모든 패키지를 확인하는 낭비를 줄이기 위해서 선택한 패키지만 탐색
        basePackages = "hello.core",
        // @Configuration은 제외(AppConfig.class)
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
}
