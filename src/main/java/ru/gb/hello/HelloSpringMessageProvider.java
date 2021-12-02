package ru.gb.hello;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("hello")
public class HelloSpringMessageProvider implements MessageProvider{

    @InjectFoodStuff
    String foodStuff;

    @Override
    public String getMessage() {
        return "Hello " + foodStuff;
    }
}
