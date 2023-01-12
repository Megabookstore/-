package com.bookstore_member.megabookstore_member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberResponse {

    private Long memberNo;

    private Long membershipNo;

    private String id;

    private String nickName;

    private boolean isMan;

    private LocalDateTime birth;

    private String password;

    private String phoneNumber;

    private String email;

    private String memberCreatedAt;
}
