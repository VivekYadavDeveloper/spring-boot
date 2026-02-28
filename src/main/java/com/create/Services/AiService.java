package com.create.Services;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class AiService {
    private final ChatClient chatClient;

    public AiService(ChatClient.Builder builder) {
        chatClient = builder.build();
    }

    public String getChatResponse(String prompt) {
        try {
            return chatClient.prompt(prompt).call().content();
        } catch (Exception e) {
            return "Learning path unavailable at the moment."; // fallback
        }
    }
}
