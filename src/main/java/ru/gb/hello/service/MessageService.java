package ru.gb.hello.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;
import ru.gb.hello.MessageProvider;
import ru.gb.hello.entity.Message;
import ru.gb.hello.repository.MessageRepository;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;

    public Message save(Message message) {
        return messageRepository.save(message);
    }

    public Message edit(Message message){
        return messageRepository.edit(message);
    }

    public Message findById(int id){
        return messageRepository.findById(id).orElse(new Message());
    }

    public Iterable<Message> findAll(){
        return messageRepository.findAll();
    }

    public long count(){
        return  messageRepository.count();
    }

    public void deleteById(int id){
        messageRepository.deleteById(id);
    }

    public Message getRandomMessage(){
        return Message.builder()
                .body(getMessageProvider().getMessage())
                .from("Randomizer")
                .to("browser")
                .build();
    }

    @Lookup
    public MessageProvider getMessageProvider(){
        return null;
    }


}
