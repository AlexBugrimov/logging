package dev.bug.logging.signature.dto;

public class Message {

    private String header;
    private String body;
    private String username;

    public String getHeader() {
        return header;
    }

    public Message setHeader(String header) {
        this.header = header;
        return this;
    }

    public String getBody() {
        return body;
    }

    public Message setBody(String body) {
        this.body = body;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public Message setUsername(String username) {
        this.username = username;
        return this;
    }
}
