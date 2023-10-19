package hello.hellospring.repository;
import java.util.*;
import hello.hellospring.domain.Member;
public interface MemberRepository {
    Member save(Member member); // 저장된 회원 반환
    Optional<Member> findById(Long id); // 아이디로 회원찾기
    Optional<Member> findByName(String name); // Optional -> 반환했을 때 null이어도 괜찮게 해주는 기능
    List<Member> findAll(); // 지금까지 저장해 온 모든 회원의 리스트를 반환해준다.
}
