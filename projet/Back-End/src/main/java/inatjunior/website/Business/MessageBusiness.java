package inatjunior.website.Business;

import inatjunior.website.Entities.Message;
import inatjunior.website.Repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MessageBusiness {

    @Autowired
    MessageRepository messageRepository;

    public Message createMessage(String name, String email, String subject, String messagetext){
        Message e = new Message(name,email,subject,messagetext);
        messageRepository.save(e);
        return e;
    }

    public Message getMessage(long id) {
            return messageRepository.getOne(id);
    }

    public void deleteMessage(Message message){
        Message e = messageRepository.getOne(message.getMessageid());
        messageRepository.delete(e);
    }

    public Message updateMessage(Message e, String username, String email, String subject, String messagetext){
            e.setUsername(username);
            e.setEmail(email);
            e.setSubject(subject);
            e.setMessagetext(messagetext);
            messageRepository.save(e);
        return e;
    }

    public List<Message> getAllMessages(){
            return messageRepository.findAll();
    }

}