package mk.ukim.finki.emt.labs.emt_labs_201504.Service;


import mk.ukim.finki.emt.labs.emt_labs_201504.Model.Author;
import mk.ukim.finki.emt.labs.emt_labs_201504.Model.Country;

import java.util.List;

public interface AuthorService {
    List<Author> listAll();

    Author findById(Long id);

    Author create(String name, String surname, Country country);

    Author update(Long id, String name, String surname, Country country);

    void delete(Long id);
}

