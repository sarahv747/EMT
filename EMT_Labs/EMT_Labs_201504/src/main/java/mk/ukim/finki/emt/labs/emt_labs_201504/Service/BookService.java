package mk.ukim.finki.emt.labs.emt_labs_201504.Service;
import mk.ukim.finki.emt.labs.emt_labs_201504.Model.Author;
import mk.ukim.finki.emt.labs.emt_labs_201504.Model.Book;
import mk.ukim.finki.emt.labs.emt_labs_201504.Model.Category;

import java.util.List;

public interface BookService {
    List<Book> listAll();

    Book findById(Long id);

    Book create(String name, Category category, Author author, Integer availableCopies);

    Book update(Long id, String name, Category category, Author author, Integer availableCopies);

    void delete(Long id);

    void borrowBook(Long id);
}

