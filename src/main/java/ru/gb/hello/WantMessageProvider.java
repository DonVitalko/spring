package ru.gb.hello;

import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Profile("want")
@Scope("prototype")
public class WantMessageProvider implements MessageProvider {

    @InjectFoodStuff
    String foodStuff;

    public WantMessageProvider(){
        System.out.println("foodStuff from constructor: " + foodStuff);
    }

    @PostConstruct
    public void init(){
        System.out.println("foodStuff from init: " + foodStuff);
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("PREDESTROY");
    }


    @Override
    public String getMessage() {
        return "I want " + foodStuff;
    }
}
