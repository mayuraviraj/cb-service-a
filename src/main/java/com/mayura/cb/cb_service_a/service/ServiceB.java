package com.mayura.cb.cb_service_a.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class ServiceB {

    private final RestTemplate restTemplate;

    public List<Object> getData(String id) {
            if(id.equalsIgnoreCase("1")) {
                return Arrays.asList(restTemplate.getForObject("https://restcountries.com/v3.1/all", Object[].class));
            } else {
                throw new RuntimeException("Connection Error");
            }

    }
}
