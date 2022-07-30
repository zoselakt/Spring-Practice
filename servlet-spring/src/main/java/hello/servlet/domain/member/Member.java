package hello.servlet.domain.member;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StreamUtils;

@Getter @Setter
public class Member {
    private Long id;
    private String username;
    private int age;

    public Member(){}

    public Member(String usernamem, int age){
        this.username = username;
        this.age = age;
    }
}
