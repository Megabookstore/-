package com.bookstore_member.megabookstore_member.dao;

import com.bookstore_member.megabookstore_member.entity.MembershipEntity;

public interface MembershipDAO {
    MembershipEntity saveMembership(MembershipEntity membershipEntity); //membership 저장
    MembershipEntity getMembership(String membershipId); //membership 조회
}
