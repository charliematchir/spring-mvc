package com.prac.mvcclone.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Member {
    private Long id;
    private String username;
    private int age;

    public Member(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public void update(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public void setId(Long id) {this.id = id;}

}
