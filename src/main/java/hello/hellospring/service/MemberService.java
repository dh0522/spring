package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.List;
//command + shift + t를 누르면 test생성
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;


    public MemberService(MemberRepository memberRepository){

        /*
             memberRepository를 memberService 파일 에서
             new로 내가 생성하는 것이 아니라
             멤버 리포지토리를 외부에서 넣어줌.
             만약 memberservice 파일에서 생생하고 test에서 이용하는 경우 다른 인스턴스를 사용하게 되므로
             처음부터 외부에서 넣어주는 값으로 설정해준다. => dependency injection di 라고함
         */

        this.memberRepository = memberRepository;
    }

    //control + T 누르면 private void로 메서드 생성하는 단축키
    /// command option v -> return 값으로
    /**
     * 회원 가입
     *
     */
    public Long join (Member member) {
        // 같은 이름이 있는 중복 회원 X!

        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();

    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m-> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
               });
    }

    /**
     * 전체 회원 조회
     *
     */
    public List<Member> findMembers(){ // 서비스 클래스는 비즈니스에 가까운 용어를 써야 한다. // repository 는 단순한 개발적인 용어로 저장

        return memberRepository.findAll();


    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
