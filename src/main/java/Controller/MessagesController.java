package Controller;



import Model.Messages;
import Service.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Message")
public class MessagesController {
    @Autowired
    private MessagesService messagesService;

    @GetMapping("/all")
    public List<Messages> getAll(){
        return messagesService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Messages> getMessages(@PathVariable("id") int id){
        return messagesService.getMessages(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Messages save(@RequestBody Messages client){
        return messagesService.save(client);
    }
}
