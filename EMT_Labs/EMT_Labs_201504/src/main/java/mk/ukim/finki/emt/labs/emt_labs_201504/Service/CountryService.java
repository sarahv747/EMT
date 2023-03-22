package mk.ukim.finki.emt.labs.emt_labs_201504.Service;

import mk.ukim.finki.emt.labs.emt_labs_201504.Model.Country;

import java.util.List;

public interface CountryService {
    List<Country> listAll();

    Country findById(Long id);

    Country create(String name, String continent);

    Country update(Long id, String name, String continent);

    void delete(Long id);
}
