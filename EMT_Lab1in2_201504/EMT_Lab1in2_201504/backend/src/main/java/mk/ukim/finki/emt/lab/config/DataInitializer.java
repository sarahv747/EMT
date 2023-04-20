package mk.ukim.finki.emt.lab.config;

import mk.ukim.finki.emt.lab.dto.AuthorDto;
import mk.ukim.finki.emt.lab.dto.BookDto;
import mk.ukim.finki.emt.lab.model.Author;
import mk.ukim.finki.emt.lab.model.Category;
import mk.ukim.finki.emt.lab.model.exceptions.InvalidAuthorIdException;
import mk.ukim.finki.emt.lab.service.AuthorService;
import mk.ukim.finki.emt.lab.service.BookService;
import mk.ukim.finki.emt.lab.service.CountryService;
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
        Author author1=authorService.create(new AuthorDto("Bokatsu ","Tsuromi", countryService.create("Taiwan","Asia").getId())).orElseThrow(InvalidAuthorIdException::new);
        Author author2=authorService.create(new AuthorDto("Stephen"," King",countryService.create("Canada","North America").getId())).orElseThrow(InvalidAuthorIdException::new);
        Author author3=authorService.create(new AuthorDto("Ayobami", "Adebayo",countryService.create("Nigeria","Africa").getId())).orElseThrow(InvalidAuthorIdException::new);
        Author author4=authorService.create(new AuthorDto("Toshiro ","Hitsugaya",countryService.create("Japan","Asia").getId())).orElseThrow(InvalidAuthorIdException::new);
        Author author5=authorService.create(new AuthorDto("Mitchell","Righton",countryService.create("Canada","North America").getId())).orElseThrow(InvalidAuthorIdException::new);

        bookService.create(new BookDto("World's End Tale", Category.NOVEL,author5.getId(),20));
        bookService.create(new BookDto("IT", Category.THRILLER,author2.getId(),15));
        bookService.create(new BookDto("Stay with me", Category.NOVEL,author3.getId(),10));
        bookService.create(new BookDto("Bleach", Category.DRAMA,author4.getId(),5));
        bookService.create(new BookDto("My Life my Rules", Category.BIOGRAPHY,author1.getId(),25));
        bookService.create(new BookDto("The Day", Category.FANTASY,author5.getId(),8));
        bookService.create(new BookDto("After the War", Category.THRILLER,author2.getId(),12));
        bookService.create(new BookDto("Love and Hate", Category.HISTORY,author3.getId(),6));
        bookService.create(new BookDto("The Tale of the Black Swamp", Category.NOVEL,author4.getId(),7));
        bookService.create(new BookDto("The Voyage of the Arctic turn", Category.CLASSICS,author5.getId(),18));

    }
}
