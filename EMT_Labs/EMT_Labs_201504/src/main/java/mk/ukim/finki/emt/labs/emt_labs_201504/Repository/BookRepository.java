package mk.ukim.finki.emt.labs.emt_labs_201504.Repository;

import mk.ukim.finki.emt.labs.emt_labs_201504.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllBooksByAuthorId(Long authorId);
}

