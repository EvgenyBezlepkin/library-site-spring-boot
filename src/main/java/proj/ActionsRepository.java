package proj;

import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface ActionsRepository extends CrudRepository<Actions, Integer> {
    Actions findById(int id);
}
