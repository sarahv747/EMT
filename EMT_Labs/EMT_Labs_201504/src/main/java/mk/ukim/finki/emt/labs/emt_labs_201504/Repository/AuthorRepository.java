package mk.ukim.finki.emt.labs.emt_labs_201504.Repository;

import mk.ukim.finki.emt.labs.emt_labs_201504.Model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}