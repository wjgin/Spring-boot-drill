package hello.hellospring;

import hello.hellospring.repository.JdbcTemplateMemberRepository;
import hello.hellospring.repository.JpaMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

// @Service, @Repository를 사용하지않고 직접 스프링에 Bean 등록
// Java 소스로 직접 config를 할 때의 장점: DB가 선정되지 않았거나 차후에 변경되어야할때, Config에서 @Bean으로 설정된 객체의 이름만 변경해주면 된다.
@Configuration
public class SpringConfig {
/*

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }
*/
    /*
    private EntityManager em;

    @Autowired
    public void SpringConfig(EntityManager em){
        this.em = em;
    }
*/

    private final MemberRepository memberRepository;

    // spring data jpa를 사용시 springdl MemberRepository 객체를 자동으로 bean으로 만듦
    // JpaRepository를 상속받은 interface가 존재 시 인터페이스에 대한 구현체를 스프링이 자체적으로 빈 생성
    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository(){
//         return new MemoryMemberRepository();
//         return new JdbcTemplateMemberRepository(dataSource);
//          return new JpaMemberRepository(em);
//      }

}
