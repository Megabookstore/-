package com.bookstore_member.megabookstore_member.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@IdClass(MemberInquiryId.class)
@Entity
public class MemberInquiryRegistration {

    @Id
    @Column(name = "member_no")
    private Long memberNo;

    @Id
    @Column(name = "member_inquiry_no")
    private Long memberInquiryNo;
}
