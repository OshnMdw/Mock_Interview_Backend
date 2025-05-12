package com.oshnmdw.mock_interview.config;

import com.oshnmdw.mock_interview.websocket.SignalingSocketHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new SignalingSocketHandler(), "/ws")
                .setAllowedOrigins("*");
    }
}
