package com.example.jsonpathexample.controller;

import com.example.jsonpathexample.service.CountryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/api/")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/getCountryNames")
    public List<String> getCountryNames() throws JsonProcessingException {
        String expression = "$.Countries[*].Country";
        return (List<String>) countryService.getFormattedResponse(expression, List.class);
    }

    @GetMapping("/getCountries")
    public List<Object> getCountries() throws JsonProcessingException {
        String expression = "$.Countries[*]";
        String expression1 = "$.Countries[*].Data";
        return (List<Object>) countryService.getFormattedResponse(expression1, List.class);
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World";
    }

}
