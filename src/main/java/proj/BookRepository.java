package proj;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {

    Book findById(Long id);

    Iterable<Book> findByNameContaining(String name);
}
