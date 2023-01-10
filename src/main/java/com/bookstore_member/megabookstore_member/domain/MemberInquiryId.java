package com.bookstore_member.megabookstore_member.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public class MemberInquiryId implements Serializable {

    private Long memberNo;

    private Long memberInquiryNo;

}
