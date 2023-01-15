package com.bookstore_member.megabookstore_member.service.memberService;

import com.bookstore_member.megabookstore_member.domain.member.Member;
import com.bookstore_member.megabookstore_member.dto.memberDto.MemberResponse;
import com.bookstore_member.megabookstore_member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberListService {

    private final MemberRepository memberRepository;

    public List<MemberResponse> memberList(Pageable pageable) {
        Page<Member> members = memberRepository.findAll(pageable);

        return members.get().map(member -> new MemberResponse(member)).collect(Collectors.toList());
    }


}
