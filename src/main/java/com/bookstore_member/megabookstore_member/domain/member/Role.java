package com.bookstore_member.megabookstore_member.domain.member;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
public enum Role {
    ROLE_ADMIN("관리자"),
    ROLE_NORMAL("일반");

    private String description;

    Role(String description){
        this.description = description;
    }
}
