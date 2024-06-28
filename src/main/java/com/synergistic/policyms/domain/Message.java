package com.synergistic.policyms.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("message")
public class Message {
    @Id
    private String id;
    private String type;
    private String referenceId;
    private String sender;
    private String recipient;
    private String message;

    public Message(String id, String type, String referenceId, String sender, String recipient, String message) {
        this.id = id;
        this.type = type;
        this.referenceId = referenceId;
        this.sender = sender;
        this.recipient = recipient;
        this.message = message;
    }

    public Message() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
