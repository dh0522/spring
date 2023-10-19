package hello.hellospring.domain;

import jakarta.persistence.*;

@Entity
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // db가 알아서 생성해주는 것 = Identity
    private Long id;// 데이터 구분을 위해 시스템이 저장함


    private String name;

    public Long getId(){

        return id;
    }
    public void setId(Long id){

        this.id = id;
    }
    public String getName(){

        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}
