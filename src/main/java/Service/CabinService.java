package Service;


import Model.Cabin;
import Repository.CabinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CabinService {
    @Autowired
    private CabinRepository cabinRepository;

    public List<Cabin> getAll(){
        return cabinRepository.getAll();
    }
    public Optional<Cabin> getCabin(int id){
        return cabinRepository.getCabin(id);
    }

    public Cabin save(Cabin cabin){
        if(cabin.getId()==null){
            return cabinRepository.save(cabin);
        }else{
            Optional<Cabin> cabinEncontrado = getCabin(cabin.getId());
            if(cabinEncontrado.isEmpty()){
                return cabinRepository.save(cabin);
            }else{
                return cabin;
            }
        }
    }
    public Cabin update(Cabin cabin){
        if(cabin.getId()!=null){
            Optional<Cabin> cabinEncontrado = getCabin(cabin.getId());
            if(!cabinEncontrado.isEmpty()){
                if(cabin.getName()!=null){
                    cabinEncontrado.get().setName(cabin.getName());
                }
                if(cabin.getBrand()!=null){
                    cabinEncontrado.get().setBrand(cabin.getBrand());
                }
                if(cabin.getYear()!=null){
                    cabinEncontrado.get().setYear(cabin.getYear());
                }
                if(cabin.getDescription()!=null){
                    cabinEncontrado.get().setDescription(cabin.getDescription());
                }
                if(cabin.getCategory()!=null){
                    cabinEncontrado.get().setCategory(cabin.getCategory());
                }
                return cabinRepository.save(cabinEncontrado.get());

            }
        }
        return cabin;
    }

    public boolean delete(int id){
        Boolean respuesta = getCabin(id).map(elemento ->{
            cabinRepository.delete(elemento);
            return true;
        }).orElse(false);
        return respuesta;
    }

}
