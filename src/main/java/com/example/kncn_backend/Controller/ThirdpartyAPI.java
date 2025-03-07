package com.example.kncn_backend.Controller;


import com.example.kncn_backend.Dto.result;
import com.example.kncn_backend.Service.VidService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;



@RequestMapping("/api")
@RestController
public class ThirdpartyAPI {

    @Autowired
    private VidService vidService;


    @GetMapping("/search/{query}")
    public String SearchVid(@PathVariable String query) throws IOException {

        // check trong database
        //.......

        // modify query
        query = query.toLowerCase();

        return vidService.VidProcess(query);

    }

}
