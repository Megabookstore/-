package com.bookstore_member.megabookstore_member.domain;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberInquiry {

    @Id
    @GeneratedValue
    @Column(name = "member_inquiry_no")
    private Long memberInquiryNo;

    @Column(name = "parent_member_inquiry_no")
    private Long parentMemberInquiryNo;

    private Long memberNo;

    private int inquiryTypeNo;

    private String title;

    private String content;

}
