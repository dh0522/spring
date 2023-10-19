package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    // *********** 테스트 끝날 때마다 저장소를 지워줌 . 따라서 오류 안나 !! **********
    @AfterEach
    // @가 끝날때마다 실행시켜주는것
    public void afterEach(){
        repository.clearStore(); // 안하면 충돌해서 오류남
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get(); // optional에서 값을 꺼낼때 get() 을 쓴다

        assertThat(member).isEqualTo(result);
        //Assertions.assertEquals(member,result); 위가 더 편하므로 위 문장쓰기
        // System.out.println("result = " + (result == member) ); //-> 윗줄 하나하나 출력할 수 없으니까 윗줄을 쓰는것 . 일치하면 푸른색 불일치하면 오류
    }
    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        // shift+f6 : 이름 한번에 변경가능
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);


        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }
    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring1");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }

}
