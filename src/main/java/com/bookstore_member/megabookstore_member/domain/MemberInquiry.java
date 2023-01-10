package com.bookstore_member.megabookstore_member.domain;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberInquiry {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long memberInquiryNo;

    @Column(nullable = false)
    private Long parentMemberInquiryNo;

    @Column(nullable = false)
    private Long memberNo;

    @Column(nullable = false)
    private int inquiryTypeNo;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "inquiry_type_no")
    private InquiryType inquiryType;



}
