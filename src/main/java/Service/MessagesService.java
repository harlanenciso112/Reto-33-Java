package Service;


import Model.Messages;
import Repository.MessagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessagesService {
    @Autowired
    private MessagesRepository messagesRepository;

    public List<Messages> getAll(){
        return messagesRepository.getAll();
    }
    public Optional<Messages> getMessages(int id){
        return messagesRepository.getMessages(id);
    }

    public Messages save(Messages messages){
        if(messages.getIdMessages()==null){
            return messagesRepository.save(messages);
        }else{
            Optional<Messages> messagesEncontrado = getMessages(messages.getIdMessages());
            if(messagesEncontrado.isEmpty()){
                return messagesRepository.save(messages);
            }else{
                return messages;
            }
        }
    }

    public Messages update(Messages messages){
        if(messages.getIdMessages()!=null){
            Optional<Messages> messagesEncontrado = getMessages(messages.getIdMessages());
            if(!messagesEncontrado.isEmpty()){
                if(messages.getMessageText()!=null){
                    messagesEncontrado.get().setMessageText(messages.getMessageText());
                }
                return messagesRepository.save(messages);
            }
        }
        return messages;
    }

    public boolean delete(int id){
        Boolean respuesta = getMessages(id).map(elemento ->{
            messagesRepository.delete(elemento);
            return true;
        }).orElse(false);
        return respuesta;
    }
}

