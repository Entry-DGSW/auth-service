package com.sugang.auth.service.auth;

import com.sugang.auth.common.client.dto.response.DauthInfoResponse.DodamUser;
import com.sugang.auth.common.kafka.UserSource;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PublishUserDataService {

    private final UserSource userSource;

    public void excute(DodamUser dodamUser) {
        userSource.output().send(MessageBuilder.withPayload(dodamUser).build());
    }
}
