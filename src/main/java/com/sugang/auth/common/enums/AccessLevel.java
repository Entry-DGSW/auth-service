package com.sugang.auth.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AccessLevel {

    STUDENT(1),
    TEACHER(2),
    ADMIN(3);

    private final int accessLevel;
}
