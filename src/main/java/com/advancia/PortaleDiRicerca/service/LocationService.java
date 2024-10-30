package com.advancia.PortaleDiRicerca.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.advancia.PortaleDiRicerca.entity.Location;
import com.advancia.PortaleDiRicerca.repository.LocationRepository;

@Service
public class LocationService {
    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }
}