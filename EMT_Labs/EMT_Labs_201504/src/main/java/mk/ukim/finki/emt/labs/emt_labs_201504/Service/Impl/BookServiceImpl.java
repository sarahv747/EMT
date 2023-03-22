package mk.ukim.finki.emt.labs.emt_labs_201504.Service.Impl;

import mk.ukim.finki.emt.labs.emt_labs_201504.Model.Author;
import mk.ukim.finki.emt.labs.emt_labs_201504.Model.Book;
import mk.ukim.finki.emt.labs.emt_labs_201504.Model.Category;
import mk.ukim.finki.emt.labs.emt_labs_201504.Model.exceptions.InvalidBookIdException;
import mk.ukim.finki.emt.labs.emt_labs_201504.Repository.BookRepository;
import mk.ukim.finki.emt.labs.emt_labs_201504.Service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> listAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return this.bookRepository.findById(id).orElseThrow(InvalidBookIdException::new);
    }

    @Override
    public Book create(String name, Category category, Author author, Integer availableCopies) {
        return this.bookRepository.save(new Book(name, category, author,availableCopies));
    }

    @Override
    public Book update(Long id, String name,Category category, Author author, Integer availableCopies) {
        Book book = this.findById(id);
        book.setName(name);
        book.setCategory(category);
        book.setAuthor(author);
        book.setAvailableCopies(availableCopies);
        return this.bookRepository.save(book);
    }

    @Override
    public void delete(Long id) {
        Book book = findById(id);
        this.bookRepository.delete(book);
    }
    @Override
    public void borrowBook(Long id) {
        Book book = findById(id);
        if(book.getAvailableCopies()==0) return;
        book.setAvailableCopies(book.getAvailableCopies()-1);
        bookRepository.save(book);
    }
}
