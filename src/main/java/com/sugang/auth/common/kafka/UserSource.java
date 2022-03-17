package com.sugang.auth.common.kafka;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface UserSource {

    String OUTPUT = "output";

    @Output(UserSource.OUTPUT)
    MessageChannel output();
}
