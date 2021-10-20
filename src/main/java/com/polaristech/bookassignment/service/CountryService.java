package com.polaristech.bookassignment.service;

import com.polaristech.bookassignment.api.ICountry;
import com.polaristech.bookassignment.common.dto.CountryDTO;
import com.polaristech.bookassignment.entity.Country;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CountryService implements ICountry {
    @Override
    public Optional<Country> getCountry(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public UUID createCountry(CountryDTO country) {
        return null;
    }
}
