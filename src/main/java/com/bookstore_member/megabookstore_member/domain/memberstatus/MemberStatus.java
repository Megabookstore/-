package com.bookstore_member.megabookstore_member.domain.memberstatus;

import com.bookstore_member.megabookstore_member.domain.memberstatus.validation.MemberStatusName;
import com.bookstore_member.megabookstore_member.domain.memberstatus.validation.MemberStatusNo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private String memberStatusNo;
    @Embedded
    private MemberStatusName memberStatusName;

    public void updateMemberStatus(String memberStatusNo, MemberStatusName memberStatusName){
        this.memberStatusNo = memberStatusNo;
        this.memberStatusName = memberStatusName;
    }
}
