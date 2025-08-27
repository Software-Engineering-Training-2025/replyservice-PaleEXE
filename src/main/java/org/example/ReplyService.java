package org.example;


import java.util.*;

/**
 * Students implement this method to return the exact outputs defined in README.
 */
public class ReplyService {
    private static final Map<String, EnumMap<ReplyType, String>> replyMap = new HashMap<>();
    private static final EnumMap<ReplyType, String> otherReplies = new EnumMap<>(ReplyType.class);

    static {
        // Populate replyMap with predefined responses from README.md.
        // Using HashMap ensures fast lookups (O(1)), allows easy extension and enhance readability
        // if new messages or reply types are added in the future.
        // I used `createReplyMap` in this way to decouple `ReplyType` orders from it use.
        replyMap.put("hi", createReplyMap(
                ReplyType.FORMAL, "Hello. How may I assist you today?",
                ReplyType.FRIENDLY, "Hey there! 😊 How can I help?",
                ReplyType.CONCISE, "Hello. How can I help?"
        ));

        replyMap.put("hello", createReplyMap(
                ReplyType.FORMAL, "Hello. How may I assist you today?",
                ReplyType.FRIENDLY, "Hi! 👋 What’s up?",
                ReplyType.CONCISE, "Hello. How can I help?"
        ));

        replyMap.put("how are you", createReplyMap(
                ReplyType.FORMAL, "I am functioning properly. How may I assist you?",
                ReplyType.FRIENDLY, "Doing great! 😄 How can I help?",
                ReplyType.CONCISE, "I’m good. How can I help?"
        ));

        replyMap.put("i need help", createReplyMap(
                ReplyType.FORMAL, "I can assist with that. Please provide more details.",
                ReplyType.FRIENDLY, "I’ve got you! 🙂 Tell me a bit more.",
                ReplyType.CONCISE, "Share details; I’ll help."
        ));

        replyMap.put("can you help me with my account", createReplyMap(
                ReplyType.FORMAL, "Certainly. Please describe the account issue.",
                ReplyType.FRIENDLY, "Sure thing! 😊 What’s wrong with the account?",
                ReplyType.CONCISE, "Describe the account issue…"
        ));

        replyMap.put("thanks", createReplyMap(
                ReplyType.FORMAL, "You are welcome.",
                ReplyType.FRIENDLY, "Anytime! 🙌",
                ReplyType.CONCISE, "You’re welcome."
        ));

        replyMap.put("bye", createReplyMap(
                ReplyType.FORMAL, "Goodbye.",
                ReplyType.FRIENDLY, "See you later! 👋",
                ReplyType.CONCISE, "Goodbye."
        ));

        replyMap.put("what is your name", createReplyMap(
                ReplyType.FORMAL, "I am your virtual assistant.",
                ReplyType.FRIENDLY, "I’m your helper bot 🤖",
                ReplyType.CONCISE, "I’m your assistant."
        ));

        // Fallback replies
        otherReplies.put(ReplyType.FORMAL, "Could you clarify your request?");
        otherReplies.put(ReplyType.FRIENDLY, "Could you tell me more?");
        otherReplies.put(ReplyType.CONCISE, "Please clarify.");
    }

    private static EnumMap<ReplyType, String> createReplyMap(Object... values) {
        EnumMap<ReplyType, String> map = new EnumMap<>(ReplyType.class);
        for (int i = 0; i < values.length; i += 2) {
            map.put((ReplyType) values[i], (String) values[i + 1]);
        }
        return map;
    }

    public String reply(String message, ReplyType type) {
        if (message == null || message.isBlank()) {
            return "Please say something.";
        }

        String key = message.trim().toLowerCase();
        Map<ReplyType, String> replies = replyMap.getOrDefault(key, otherReplies);
        return replies.get(type);
    }
}
