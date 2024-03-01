package com.example.Web_prac.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
    private Long memberId;
    private String userName;
    private String userId;
    private String userPw;
}
