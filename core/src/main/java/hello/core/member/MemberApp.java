package hello.core.member;

import hello.core.AppConfig;

public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService;

        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();

        Member memeber = new Member(1L, "memeberA", Grade.VIP);
        memberService.join(memeber);

        Member findMember = memberService.findMemeber(1L);

        System.out.println("new memeber = " + memeber.getName());
        System.out.println("find member = " + findMember.getName());
    }
}
