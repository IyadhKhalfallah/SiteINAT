package inatjunior.website.Controllers;

import inatjunior.website.Business.*;
import inatjunior.website.Entities.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class MessageController {

    @Autowired
    MessageBusiness messageBusiness;

    @PostMapping("/message")
    public Message createMessage(@RequestBody Message e){
        return messageBusiness.createMessage(e.getUsername(),e.getEmail(),e.getSubject(),e.getMessagetext());
    }

    @GetMapping(value = "/message/{id}")
    public Message getMessage(@PathVariable("id") long id){
        Message e = messageBusiness.getMessage(id);
        return e;
    }

    @DeleteMapping(value = "/message/{id}")
    public void deleteMessage(@PathVariable("id") long id){
        Message e = messageBusiness.getMessage(id);
        messageBusiness.deleteMessage(e);
    }

    @PutMapping(value = "/message/{id}")
    public Message updateMessage(@PathVariable("id") long id, @RequestBody Message n){
        Message e = messageBusiness.getMessage(id);
        return messageBusiness.updateMessage(e,n.getUsername(),n.getEmail(),n.getSubject(),n.getMessagetext());
    }

    @GetMapping("/messages")
    public List<Message> getAllMessages(){
        return messageBusiness.getAllMessages();
    }

}
