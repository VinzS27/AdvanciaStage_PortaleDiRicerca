package com.advancia.PortaleDiRicerca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.advancia.PortaleDiRicerca.entity.Country;

public interface CountryRepository extends JpaRepository<Country, String> {

}
