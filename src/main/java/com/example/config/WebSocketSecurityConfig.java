package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.config.annotation.web.socket.EnableWebSocketSecurity;
import org.springframework.security.messaging.access.intercept.MessageMatcherDelegatingAuthorizationManager;

@Configuration
@EnableWebSocketSecurity
public class WebSocketSecurityConfig {

    // @formatter:off
	@Bean
	AuthorizationManager<Message<?>> messageAuthorizationManager(MessageMatcherDelegatingAuthorizationManager.Builder messages) {
		messages
			.simpMessageDestMatchers("/queue/**", "/topic/**").denyAll()
			.simpSubscribeDestMatchers("/queue/*-user*", "/topic/*-user*").denyAll()
			.anyMessage().authenticated();
		return messages.build();
	}
	// @formatter:on

}
