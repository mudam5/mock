package myapp.logsystem.model;

import java.time.LocalDateTime;

public class LogEvent {

    private String level;

    private String message;

    private LocalDateTime timestamp;

    public LogEvent(String level, String message) {

        this.level = level;

        this.message = message;

        this.timestamp = LocalDateTime.now();

    }

    public String getLevel() { return level; }

    public String getMessage() { return message; }

    public LocalDateTime getTimestamp() { return timestamp; }

    @Override

    public String toString() {

        return timestamp + " [" + level + "] " + message;

    }

}
 
