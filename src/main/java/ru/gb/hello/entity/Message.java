package ru.gb.hello.entity;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Message {
    private Integer id;
    private String body;
    private String from;

    public void setId(Integer id) {
        this.id = id;
    }

    private String to;

    public Integer getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }
}
