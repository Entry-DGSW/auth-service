package com.sugang.auth.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AccessLevel {

    STUDENT(1),
    PARENT(2),
    TEACHER(3),
    ADMIN(4);


    private final int accessLevel;
}
