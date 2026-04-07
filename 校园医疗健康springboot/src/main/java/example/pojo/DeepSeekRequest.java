package example.pojo;

import java.util.List;

public class DeepSeekRequest {
    private String model;
    private List<Message> messages;

    // Getter and Setter for model
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    // Getter and Setter for messages
    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    // Nested Message class
    public static class Message {
        private String role;
        private String content;

        // Constructor
        public Message(String role, String content) {
            this.role = role;
            this.content = content;
        }

        // Getter and Setter for role
        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        // Getter and Setter for content
        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        // Override toString()
        @Override
        public String toString() {
            return "Message{" +
                    "role='" + role + '\'' +
                    ", content='" + content + '\'' +
                    '}';
        }

        // Override equals()
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Message message = (Message) o;
            return role.equals(message.role) && content.equals(message.content);
        }

        // Override hashCode()
        @Override
        public int hashCode() {
            return 31 * role.hashCode() + content.hashCode();
        }
    }

    // Override toString()
    @Override
    public String toString() {
        return "DeepSeekRequest{" +
                "model='" + model + '\'' +
                ", messages=" + messages +
                '}';
    }

    // Override equals()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeepSeekRequest that = (DeepSeekRequest) o;
        return model.equals(that.model) && messages.equals(that.messages);
    }

    // Override hashCode()
    @Override
    public int hashCode() {
        return 31 * model.hashCode() + messages.hashCode();
    }
}