package com.bookstore_member.megabookstore_member.exception;

public class NotFoundException extends IllegalArgumentException{

    public NotFoundException() {
        super("찾으시는 회원이 존재하지 않습니다");
    }
}
