package com.web.seek.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter @Entity
@Table
public class User extends BaseTimeEntity{
    @Id @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String password;

    @Column
    private String email;

    @Builder
    public User(Long id, String name, String password, String email){
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }
}
