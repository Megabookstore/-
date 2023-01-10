package com.bookstore_member.megabookstore_member.dto;

import com.bookstore_member.megabookstore_member.domain.MemberInquiry;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberRequest {

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
