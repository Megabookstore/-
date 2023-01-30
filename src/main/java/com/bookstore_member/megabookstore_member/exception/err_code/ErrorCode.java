package com.bookstore_member.megabookstore_member.exception.err_code;

import lombok.Getter;

@Getter
public enum ErrorCode {

    ID_NOT_EMPTY("아이디는 빈값을 허용하지 않습니다"),
    EMAIL_NOT_EMPTY("닉네임은 빈값을 허용하지 않습니다"),
    NICKNAME_NOT_EMPTY("닉네임은 빈값을 허용하지 않습니다"),

    PHONE_NUMBER_NOT_EMPTY ("휴대폰 번호는 빈값을 허용하지 않습니다");


    private final String errCode;

    ErrorCode(String errCode) {
        this.errCode = errCode;
    }


    }
