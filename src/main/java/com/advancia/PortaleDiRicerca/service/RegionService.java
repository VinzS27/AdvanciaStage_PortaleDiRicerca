package com.advancia.PortaleDiRicerca.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.advancia.PortaleDiRicerca.entity.Region;
import com.advancia.PortaleDiRicerca.repository.RegionRepository;

@Service
public class RegionService {
    private final RegionRepository regionRepository;

    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public List<Region> getAllRegions() {
        return regionRepository.findAll();
    }
}