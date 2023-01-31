package prac.prac01.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import prac.prac01.domain.Member;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void AfterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        //given
        Member member = new Member();
        member.setName("firstFuckU");

        //when
        repository.save(member);

        //then
        Member result = repository.findById(member.getId()).get();
        assertThat(result).isEqualTo(member);
    }

    @Test
    public void findByName(){
        //given
        Member member1 = new Member();
        member1.setName("1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("2");
        repository.save(member2);

        //when
        Member result = repository.findByName("1").get();

        //then
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        //given
        Member member1 = new Member();
        member1.setName("1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("2");
        repository.save(member2);

        //when
        List<Member> result = repository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
    }

}
