package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member > store = new HashMap<>();
    private static long sequence = 0L; // 0 1 2 키값을 생성해주는 애

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // 없으면 결과가 null임 -> optional로 감싸면 null이어도 ㄱㅊ
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny(); // 동일한 애 반환

    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); // member 반환
    }

    public void clearStore(){
        store.clear();
    }
}
