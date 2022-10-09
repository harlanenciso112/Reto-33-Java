package Controller;


import Repository.CabinRepository;
import Model.Cabin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

@RestController
@RequestMapping("/api/Cabin")
public class CabinController {

    @Autowired
    private CabinRepository cabinService;

    @GetMapping("/all")
    public List<Cabin> getCabin(){
        return cabinService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Cabin> getCategory(@PathVariable("id") int id){
        return cabinService.getCabin(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cabin save(@RequestBody Cabin cabin){
        return cabinService.save(cabin);
    }
}
