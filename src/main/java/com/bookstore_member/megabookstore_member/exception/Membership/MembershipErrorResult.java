package com.bookstore_member.megabookstore_member.exception.Membership;
//MembershipErrorResult를 만든 이유는 추후 MembershipException이 throw되었을 때
//RestControllerAdvice를 통해 membershipErrorResult의 HttpStatus와 message를 반환하기 위해서
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum MembershipErrorResult {

    DUPLICATED_MEMBERSHIP_REGISTER(HttpStatus.BAD_REQUEST,"Duplicated Membership Register Request");

    private final HttpStatus httpStatus;

    private final String message;

}
