package com.cybercom.gustafbratt.kalender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KalenderController {

    @Autowired
    KalenderConfig kalenderConfig;

    @GetMapping("/hello")
    ResponseEntity<List<String>> hello() {
        return new ResponseEntity<List<String>>(kalenderConfig.getRodaDagar(), HttpStatus.OK);
    }
}
