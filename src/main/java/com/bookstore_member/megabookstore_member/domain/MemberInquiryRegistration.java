package com.bookstore_member.megabookstore_member.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class MemberInquiryRegistration {

    @EmbeddedId
    private Pk pk;

    @MapsId("memberNo")
    @ManyToOne
    @JoinColumn(name = "member_no")
    private Member member;

    @MapsId("memberInquiryNo")
    @ManyToOne
    @JoinColumn(name = "member_inquiry_no")
    private MemberInquiry memberInquiry;

    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    @Getter
    @Setter
    @Embeddable
    public static class Pk implements Serializable {

        @Column(name = "member_no")
        private Long memberNo;

        @Column(name = "member_inquiry_no")
        private Long memberInquiryNo;
    }
}
