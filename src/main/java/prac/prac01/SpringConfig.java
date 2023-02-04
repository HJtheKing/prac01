package prac.prac01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import prac.prac01.repository.MemberRepository;
import prac.prac01.repository.MemoryMemberRepository;
import prac.prac01.service.MemberService;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
