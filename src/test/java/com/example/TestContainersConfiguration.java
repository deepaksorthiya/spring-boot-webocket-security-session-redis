package com.example;

import com.redis.testcontainers.RedisContainer;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;

class TestContainersConfiguration {

    private static final String REDIS_IMAGE = "redis:latest";

    @Container
    @ServiceConnection
    private static final RedisContainer redisContainer = new RedisContainer(DockerImageName.parse(REDIS_IMAGE))
            .withExposedPorts(6379);


    @DynamicPropertySource
    static void envProperties(DynamicPropertyRegistry registry) {
        //optional @serviceconnection take care of it
        //registry.add("spring.data.redis.port", redisContainer::getFirstMappedPort);
        //registry.add("spring.data.redis.host", redisContainer::getHost);
        System.out.println(redisContainer);
    }

}
