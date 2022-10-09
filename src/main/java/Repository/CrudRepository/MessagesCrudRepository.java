package Repository.CrudRepository;


import Model.Messages;
import org.springframework.data.repository.CrudRepository;

public interface MessagesCrudRepository extends CrudRepository<Messages, Integer> {
}
