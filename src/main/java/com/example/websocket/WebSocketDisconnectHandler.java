package com.example.websocket;

import com.example.data.ActiveWebSocketUserRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.util.Collections;

public class WebSocketDisconnectHandler<S> implements ApplicationListener<SessionDisconnectEvent> {

    private ActiveWebSocketUserRepository repository;

    private SimpMessageSendingOperations messagingTemplate;

    public WebSocketDisconnectHandler(SimpMessageSendingOperations messagingTemplate,
                                      ActiveWebSocketUserRepository repository) {
        super();
        this.messagingTemplate = messagingTemplate;
        this.repository = repository;
    }

    @Override
    public void onApplicationEvent(SessionDisconnectEvent event) {
        String id = event.getSessionId();
        if (id == null) {
            return;
        }
        this.repository.findById(id).ifPresent((user) -> {
            this.repository.deleteById(id);
            this.messagingTemplate.convertAndSend("/topic/friends/signout",
                    Collections.singletonList(user.getUsername()));
        });
    }

}
