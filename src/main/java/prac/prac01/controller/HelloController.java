package prac.prac01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    /*
    mvc방식(model, view, controller)
    */
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "존만아");
        model.addAttribute("num", "123");
        return "hello";
    }
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name12") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    /*
    API방식
    */
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name123") String name){
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name1234") String name, @RequestParam("num") Long num){
        Hello hello = new Hello();
        hello.setName(name);
        hello.setNum(num);
        return hello;
    }

    static class Hello{
        private String name;
        private Long num;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Long getNum() {
            return num;
        }

        public void setNum(Long num) {
            this.num = num;
        }
    }
}
