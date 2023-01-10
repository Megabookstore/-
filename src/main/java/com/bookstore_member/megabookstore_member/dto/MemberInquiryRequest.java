package com.bookstore_member.megabookstore_member.dto;


import com.bookstore_member.megabookstore_member.domain.InquiryType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberInquiryRequest {


    private Long memberInquiryNo;

    private Long parentMemberInquiryNo;

    private Long memberNo;

    private int inquiryTypeNo;

    private String title;

    private String content;

    private InquiryType inquiryType;
}
