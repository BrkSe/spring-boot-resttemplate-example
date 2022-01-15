package com.burakkutbay.springbootresttemplateexample.controller;

import com.burakkutbay.springbootresttemplateexample.pojo.Character;
import com.burakkutbay.springbootresttemplateexample.service.ApiService;
import com.burakkutbay.springbootresttemplateexample.service.ApiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @Autowired
    private ApiService apiService;

    @GetMapping("/")
    public ResponseEntity<Character> getCharacters() {
        Character characters = apiService.getAllCharacter();
        return new ResponseEntity<>(characters, HttpStatus.OK);
    }
}
