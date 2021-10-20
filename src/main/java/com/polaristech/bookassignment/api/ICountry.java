package com.polaristech.bookassignment.api;

import com.polaristech.bookassignment.common.dto.CountryDTO;
import com.polaristech.bookassignment.entity.Country;

import java.util.Optional;
import java.util.UUID;

public interface ICountry {
    Optional<Country> getCountry(UUID uuid);

    UUID createCountry(CountryDTO country);
}
