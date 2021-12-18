package com.spacedev.board.chatHandler;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;


public class HashTest {

    private final Logger log = LoggerFactory.getLogger(HashTest.class);

    @Test
    @DisplayName("모든 온라인 유저에게 메세지 전달")
    void sendToAll(){
        Map<String, String> onlineUser = new HashMap<>();
        Map<String, String> message = new HashMap<>();
        String msg;

        onlineUser.put("userA", "A");
        onlineUser.put("userB", "B");
        onlineUser.put("userC", "C");
        onlineUser.put("userD", "D");

        onlineUser.keySet().parallelStream().forEach(key ->{
            // String msg 맵에 key값 추가

            log.info(key);
        });
     }
}
