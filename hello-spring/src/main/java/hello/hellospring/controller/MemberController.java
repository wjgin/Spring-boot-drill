package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private MemberService memberService;
    /**
     // DI 방식 중 필드 주입 방식(권장되지 않음)
     // 필드에 객체를 주입하는 것 이외의 다른 행위를 할 수 없기에 잘 사용되지 않음
     @Autowired private MemberService memberService;

    // DI 중 Setter 주입방식(권장되지 않음)
    // setter 주입 방식의 경우 memberService 객체를 final로 사용하지 못하고 set 메소드가 public으로 설정 되어야한다.
    // 다른 곳에서 개발자가 memberService 객체를 수정할 수 있기에 권장되지 않는 방식
    @Autowired
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }
 */

    // DI 중 생성자 주입 방식(가장 권장됨)
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
