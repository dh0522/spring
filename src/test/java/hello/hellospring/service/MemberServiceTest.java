package hello.hellospring.service;


import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

// test 같은 경우는 과감하게 한글로 바꾸어도 됩니다.
//  테스트는 예외가 터트려지는 경우도 만들어서 봐야한다.
class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;  // db 데이터 갱신해줌

    // 테스트 실행 전에 메모리리포지터리를 만들어주고 멤버서비스에 넣어줌. = > 항상 동일
    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore(); // 안하면 충돌해서 오류남
    }

    @Test
    void 회원가입() {

        // given
        Member member = new Member();
        member.setName("spring");

        // when

        Long saveId = memberService.join(member);

        // then = 검증
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());

    }

    // test는 예외 상태가 더 중요함
    @Test
    public void 중복_회원_예외(){
        //given

        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when

        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        /*

        try {
            memberService.join(member2);
            fail(); -> 예외 발생
        }catch(IllegalStateException e){
            // 예외 처리 -> 중복되는 회원이 있는 경우
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다. 123123");
        }
*/

        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}