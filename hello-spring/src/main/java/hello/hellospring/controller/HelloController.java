package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello spring!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    // public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model){
    public String helloMvc(@RequestParam("name") String name, Model model){ // required 기본은 true
        model.addAttribute("data", name);
        return "hello-template";    // viewResolver가 해당 view를 찾음
    }

    // API 방식 => data를 직접 전달(HttpMessageConverter), Json 형식
    @GetMapping("hello-api")
    @ResponseBody   // api 방식 실행
    public Hello helloApi(@RequestParam("name")String name) {
        Hello hello = new Hello();
        hello.setName(name);

        return hello;   // 객체를 직접 전달 => json으로 넘김
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
