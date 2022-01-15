package com.burakkutbay.springbootresttemplateexample.service;

import com.burakkutbay.springbootresttemplateexample.pojo.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ApiServiceImpl implements ApiService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HttpHeaders httpHeaders;

    private static final String CHAHRACTER_API = "https://rickandmortyapi.com/api/character";

    @Override
    public Character getAllCharacter() {

        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);

        ResponseEntity<Character> response = restTemplate.exchange(CHAHRACTER_API, HttpMethod.GET,
                entity, Character.class);

        return response.getBody();
    }
}
