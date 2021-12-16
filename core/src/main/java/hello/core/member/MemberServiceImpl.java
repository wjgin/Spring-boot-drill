package hello.core.member;

public class MemberServiceImpl implements MemberService{

    /**
     * AppConfig 로 인한 구현체는 제외하고 추상화에만 의존 DIP
     */
    // private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMemeber(Long MemberId) {
        return memberRepository.findById(MemberId);
    }

}
