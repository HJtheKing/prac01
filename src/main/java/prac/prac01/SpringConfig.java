package prac.prac01;

import org.hibernate.persister.walking.spi.EntityIdentifierDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import prac.prac01.repository.JpaMemberRepository;
import prac.prac01.repository.MemberRepository;
import prac.prac01.repository.MemoryMemberRepository;
import prac.prac01.service.MemberService;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import javax.xml.crypto.Data;

@Configuration
public class SpringConfig {

    private final DataSource dataSource;
    private final EntityManager em;

    public SpringConfig(DataSource dataSource, EntityManager em){
        this.dataSource = dataSource;
        this.em = em;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
        return new JpaMemberRepository(em);
    }
}
