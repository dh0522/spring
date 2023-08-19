package hello.hellospring.repository;
import java.util.*;
import hello.hellospring.domain.Member;
public interface MemberRepository {
    Member save(Member member); // 저장된 회원 반환
    Optional<Member> findById(Long id); // 아이디로 회원찾기
    Optional<Member> findByName(String name); // Optional -> 반환했을때 null이면... 다음에 설명
    List<Member> findAll();
}
