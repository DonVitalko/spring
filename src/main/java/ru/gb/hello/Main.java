package ru.gb.hello;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.gb.hello.config.HelloConfiguration;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HelloConfiguration.class);
        System.out.println(Arrays.asList(context.getBeanDefinitionNames()));
        for (int i = 0; i < 5; i++) {
            MessageRender messageRender = context.getBean(MessageRender.class);
            messageRender.render();
        }
        context.close();
    }
}
