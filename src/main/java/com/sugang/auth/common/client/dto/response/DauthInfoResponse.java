package com.sugang.auth.common.client.dto.response;

import com.sugang.auth.common.enums.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@AllArgsConstructor
public class DauthInfoResponse {

    private int status;
    private String message;
    private DodamUser data;

    @Getter
    @Setter
    public static class DodamUser {
        private String uniqueId;
        private int grade;
        private int room;
        private int number;
        private String name;
        private String profileImage;
        private AccessLevel accessLevel;
        private String email;
    }
}