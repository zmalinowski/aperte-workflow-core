package org.aperteworkflow.editor.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Main configuration for the process editor application
 */
public class ProcessConfig implements Serializable {

    private List<Permission> processPermissions;
    private List<Queue> queues;

    // This Map should be parametrized as <Language, String> however Jackson does not support
    // this out of the box, @see http://stackoverflow.com/questions/6371092/can-not-find-a-map-key-deserializer-for-type-simple-type-class-com-comcast-i
    // we use this dirty approach instead of registering custom module for Language class serialization
    private Map<String, String> messages;

    private byte[] processIcon;

    public List<Permission> getProcessPermissions() {
        return processPermissions;
    }

    public void setProcessPermissions(List<Permission> processPermissions) {
        this.processPermissions = processPermissions;
    }

    public List<Queue> getQueues() {
        return queues;
    }

    public void setQueues(List<Queue> queues) {
        this.queues = queues;
    }

    public byte[] getProcessIcon() {
        return processIcon;
    }

    public void setProcessIcon(byte[] processIcon) {
        this.processIcon = processIcon;
    }

    public Map<String, String> getMessages() {
        return messages;
    }

    public void setMessages(Map<String, String> messages) {
        this.messages = messages;
    }
}
