package com.advancia.PortaleDiRicerca.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.advancia.PortaleDiRicerca.entity.Country;
import com.advancia.PortaleDiRicerca.repository.CountryRepository;

@Service
public class CountryService {
    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }
}