package ru.gb.hello.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.hello.MessageProvider;
import ru.gb.hello.entity.Message;
import ru.gb.hello.service.MessageService;

@Controller
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @GetMapping("/create")
    public String showSimpleForm(Model model){
        Message message = new Message();
        model.addAttribute("message", message);
        return "create-message";
    }

    @PostMapping("/create")
    public String processForm(Message message){
        if(message.getId() == null){
            messageService.save(message);
        } else{
            messageService.edit(message);
        }
        return "redirect:/message/all";
    }

    @GetMapping("/{id}")
    public String getMessageById(Model model,
                                 @PathVariable Integer id,
                                 @RequestParam(name = "random", defaultValue = "false", required = false) Boolean isRandom){
        Message message = null;
        if(isRandom){
            message = messageService.getRandomMessage();
        }else{
            message = messageService.findById(id);
        }
        model.addAttribute("message", message);
        return "message";
    }

    @GetMapping("/all")
    public String getAllMessage(Model model){
        model.addAttribute("messages", messageService.findAll());
        return "message-list";
    }

    @GetMapping("/delete")
    public String deleteById(@RequestParam Integer id){
        messageService.deleteById(id);
        return "redirect:/message/all";
    }

    @GetMapping("/edit")
    public String editById(Model model, @RequestParam Integer id){
        Message message = messageService.findById(id);
        model.addAttribute("message", message);
        return "create-message";
    }
}
