package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.JdbcMemberRepository;
import hello.hellospring.repository.JpaMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
/*
    // 스프링 빈에 등록하라는 뜻이네 하고 스프링이 인식함.

    private DataSource dataSource; //-> db를 만들어주고 autowired르 주입해준다.

    @Autowired
    public SpringConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }
*/
//    private EntityManager em;
//
//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){

        return new MemberService(memberRepository);
    }
//    @Bean
//    public TimeTraceAop timeTraceAop() {
//        return new TimeTraceAop();
//    }

//    @Bean
//    public MemberRepository memberRepository(){
        // return new MemoryMemberRepository();
        //return new JdbcMemberRepository( dataSource );
        //return new JdbcMemberRepository(dataSource);
        //return new JpaMemberRepository(em);
//    }
}
