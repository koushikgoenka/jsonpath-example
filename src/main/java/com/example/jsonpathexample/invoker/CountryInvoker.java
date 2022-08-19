package com.example.jsonpathexample.invoker;

import com.example.jsonpathexample.dto.Country;
import com.example.jsonpathexample.dto.CountryResponse;
import com.example.jsonpathexample.dto.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CountryInvoker {

    public CountryResponse getCountryInfo() {
        CountryResponse response = new CountryResponse();
        response.setDescription("Map containing Country, Capital, Currency, and some States of that Country");
        response.setRegion("Asia");

        List<Country> countries = new ArrayList<>();

        Country country1 = new Country();
        country1.setCountry("India");
        Data data1 = new Data("Delhi", 5, 45, "Indian Rupee");
        country1.setData(data1);

        Country country2 = new Country();
        country2.setCountry("Nepal");
        Data data2 = new Data("Kathmandu", 2, 35, "Nepalese Rupee");
        country2.setData(data2);

        countries.add(country1);
        countries.add(country2);

        response.setCountries(countries);

        return response;
    }
}
