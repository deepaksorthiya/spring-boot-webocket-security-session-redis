package com.example.config;

import com.example.data.ActiveWebSocketUserRepository;
import com.example.websocket.WebSocketConnectHandler;
import com.example.websocket.WebSocketDisconnectHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.session.Session;

/**
 * These handlers are separated from WebSocketConfig because they are specific to this
 * application and do not demonstrate a typical Spring Session setup.
 */
@Configuration
public class WebSocketHandlersConfig<S extends Session> {

    @Bean
    public WebSocketConnectHandler<S> webSocketConnectHandler(SimpMessageSendingOperations messagingTemplate,
                                                              ActiveWebSocketUserRepository repository) {
        return new WebSocketConnectHandler<>(messagingTemplate, repository);
    }

    @Bean
    public WebSocketDisconnectHandler<S> webSocketDisconnectHandler(SimpMessageSendingOperations messagingTemplate,
                                                                    ActiveWebSocketUserRepository repository) {
        return new WebSocketDisconnectHandler<>(messagingTemplate, repository);
    }

}
