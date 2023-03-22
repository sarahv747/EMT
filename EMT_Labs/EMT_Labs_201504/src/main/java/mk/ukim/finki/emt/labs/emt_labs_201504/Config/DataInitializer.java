package mk.ukim.finki.emt.labs.emt_labs_201504.Config;

import mk.ukim.finki.emt.labs.emt_labs_201504.Model.Author;
import mk.ukim.finki.emt.labs.emt_labs_201504.Model.Category;
import mk.ukim.finki.emt.labs.emt_labs_201504.Service.AuthorService;
import mk.ukim.finki.emt.labs.emt_labs_201504.Service.BookService;
import mk.ukim.finki.emt.labs.emt_labs_201504.Service.CountryService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataInitializer {
    private final BookService bookService;

    private final AuthorService authorService;
    private final CountryService countryService;

    public DataInitializer(BookService bookService, AuthorService authorService, CountryService countryService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.countryService = countryService;
    }


    @PostConstruct
    public void initData() {
        Author author1=authorService.create("J.K. ","Rowling", countryService.create("UK","Europe"));
        Author author2=authorService.create("Stephen"," King",countryService.create("Canada","North America"));
        Author author3=authorService.create("Chimamanda Ngozi", "Adichie",countryService.create("Nigeria","Africa"));
        Author author4=authorService.create("Haruki","Murakami",countryService.create("Japan","Asia"));
        Author author5=authorService.create("Margaret"," Atwood",countryService.create("Canada","North America"));

        bookService.create("The Voyager", Category.NOVEL,author5,20);
        bookService.create("The Shining", Category.THRILLER,author2,15);
        bookService.create("New Yorker", Category.NOVEL,author3,10);
        bookService.create("Morreti", Category.DRAMA,author4,5);
        bookService.create("Harry Potter", Category.BIOGRAPHY,author1,25);
        bookService.create("Thrill", Category.FANTASY,author5,8);
        bookService.create("Mouse", Category.THRILLER,author2,12);
        bookService.create("World war III", Category.HISTORY,author3,6);
        bookService.create("Hoods", Category.NOVEL,author4,7);
        bookService.create("The Testament", Category.CLASSICS,author5,18);

    }
}
