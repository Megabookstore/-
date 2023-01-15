package com.bookstore_member.megabookstore_member.dao.Impl;

import com.bookstore_member.megabookstore_member.dao.MembershipDAO;
import com.bookstore_member.megabookstore_member.entity.MembershipEntity;
import com.bookstore_member.megabookstore_member.repository.MembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembershipDAOImpl implements MembershipDAO {

    MembershipRepository membershipRepository;

    @Autowired //자동연결(미리 생성한 repository 가져와서 주입)
    public MembershipDAOImpl(MembershipRepository membershipRepository){
        this.membershipRepository = membershipRepository;
    }
    @Override
    public MembershipEntity saveMembership(MembershipEntity membershipEntity){
        membershipRepository.save(membershipEntity);
        return membershipEntity;
    }
    @Override
    public MembershipEntity getMembership(String membershipId){
        MembershipEntity membershipEntity = membershipRepository.getById(membershipId);
        return membershipEntity;
    }
}
