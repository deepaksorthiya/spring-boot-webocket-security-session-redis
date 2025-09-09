package com.example.mvc;

import com.example.data.ActiveWebSocketUserRepository;
import com.example.data.InstantMessage;
import com.example.data.User;
import com.example.security.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Controller for managing {@link Message} instances.
 *
 * @author Rob Winch
 *
 */
@Controller
public class MessageController {

    private SimpMessageSendingOperations messagingTemplate;

    private ActiveWebSocketUserRepository activeUserRepository;

    @Autowired
    public MessageController(ActiveWebSocketUserRepository activeUserRepository,
                             SimpMessageSendingOperations messagingTemplate) {
        this.activeUserRepository = activeUserRepository;
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/im")
    public void im(InstantMessage im, @CurrentUser User currentUser) {
        im.setFrom(currentUser.getEmail());
        this.messagingTemplate.convertAndSendToUser(im.getTo(), "/queue/messages", im);
        this.messagingTemplate.convertAndSendToUser(im.getFrom(), "/queue/messages", im);
    }

    @SubscribeMapping("/users")
    public List<String> subscribeMessages() {
        return this.activeUserRepository.findAllActiveUsers();
    }

}
