package com.bookstore_member.megabookstore_member.exception.Membership;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public class MembershipException extends RuntimeException {
    private final MembershipErrorResult errorResult;
}


