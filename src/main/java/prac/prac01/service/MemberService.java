package prac.prac01.service;

import prac.prac01.domain.Member;
import prac.prac01.repository.MemberRepository;
import prac.prac01.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    /*
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    기존 : 멤버서비스에서 회원 리포지토리를 직접 생성 -> 회원 서비스 코드를 DI 가능하게 변경
    */

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /*회원가입*/
    public Long join(Member member){
        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    /* ctrl + shift + alt + t -> extract method : 메서드 추출 */
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m ->{
                    throw new IllegalStateException("이미 존재하는 회원.");
                });
    }

    /*전체 회원 조회*/
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long id){
        return memberRepository.findById(id);
    }

}
