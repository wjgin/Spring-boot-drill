package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service
public class MemberService {
    // command shift T 단축키로 test 껍데기 자동 생성 가능

    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    /**
    * 회원가입
    */
    public Long join(Member member) {
        validateDuplicateMember(member);    // 중복회원 검증
        repository.save(member);
        return member.getId();
    }

    // 필요한 기능을 외부 메소드로 추출(단축키 command option m 혹은 ctl T 에서 확인)
    private void validateDuplicateMember(Member member) {
        // Optional로 감싼 객체 -> 존재하지 않으면 null
        // Optional<Member> byName = repository.findByName(member.getName());
        repository.findByName(member.getName())
                        .ifPresent(m-> {    // Optional로 감싼 객체의 존재를 확인하는 메소드 (존재한다면 m은 not null)
                            throw new IllegalStateException("이미 존재하는 회원 입니다.");
                        });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMemebers(){
        return repository.findAll();
    }

    public Optional<Member> findOne(Long id){
        return repository.findById(id);
    }
}
