package com.example.jsonpathexample.service;

import com.example.jsonpathexample.dto.CountryResponse;
import com.example.jsonpathexample.invoker.CountryInvoker;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    @Autowired
    private CountryInvoker invoker;

    ObjectMapper mapper = new ObjectMapper();

    public Object getFormattedResponse(String jsonExpression, Class<?> classType) throws JsonProcessingException {
        CountryResponse response = invoker.getCountryInfo();
        String jsonResponse = mapper.writeValueAsString(response);
        Object countryReponse = JsonPath.parse(jsonResponse).read(jsonExpression, classType);
        return countryReponse;
    }
}
