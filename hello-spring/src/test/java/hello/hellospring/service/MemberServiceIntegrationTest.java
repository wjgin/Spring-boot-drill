package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest // 스프링 통합 테스트
@Transactional  // 트랜젝션 롤백 기능(after, before each 불 필요) :spring-jdbc 라이브러리 제공
class MemberServiceIntegrationTest {

    // 테스트의 경우, 필드 주입도 사용
    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;   // 구현체가 아닌 인터페이스를 등록(스프링이 구현체를 찾아줌)

    // 테스트 코드는 한글도 가능
    @Test
    // @Commit Transactional이 최상에 붙어도 commit 해줌
    void 회원가입() {
        // given
        Member member = new Member();
        member.setName("spring");

        // when
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(findMember.getName()).isEqualTo(member.getName());
    }

    @Test
    void 중복_회원_가입(){
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when
        memberService.join(member1);

        // then
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원 입니다.");
        /*
            try {
                memberService.join(member2);
                fail();
            } catch (IllegalStateException e) {
                assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원 입니다.");
            }
        */
    }

    @Test
    void findMemebers() {
    }

    @Test
    void findOne() {
    }
}