package mk.ukim.finki.emt.labs.emt_labs_201504.Service.Impl;

import mk.ukim.finki.emt.labs.emt_labs_201504.Model.Country;
import mk.ukim.finki.emt.labs.emt_labs_201504.Model.exceptions.InvalidCountryException;
import mk.ukim.finki.emt.labs.emt_labs_201504.Repository.CountryRepository;
import mk.ukim.finki.emt.labs.emt_labs_201504.Service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }


    @Override
    public List<Country> listAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Country findById(Long id) {
        return this.countryRepository.findById(id).orElseThrow(InvalidCountryException::new);
    }

    @Override
    public Country create(String name, String continent) {
        return this.countryRepository.save(new Country(name,continent));
    }

    @Override
    public Country update(Long id, String name, String continent) {
        Country country = this.findById(id);
        country.setName(name);
        country.setContinent(continent);
        countryRepository.save(country);
        return country;
    }

    @Override
    public void delete(Long id) {
        Country country = findById(id);
        this.countryRepository.delete(country);
    }

}