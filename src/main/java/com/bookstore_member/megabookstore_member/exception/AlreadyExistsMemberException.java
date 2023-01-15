package com.bookstore_member.megabookstore_member.exception;

public class AlreadyExistsMemberException extends IllegalArgumentException {

    public AlreadyExistsMemberException() {
        super("이미 존재하는 회원입니다.");
    }
}
