package com.cybercom.gustafbratt.kalender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v2/kalender")
public class KalenderControllerV2 {

    @Autowired
    KalenderConfig kalenderConfig;

    @GetMapping("/rodadagar")
    ResponseEntity<List<String>> rodaDagar() {
        return new ResponseEntity<>(kalenderConfig.getRodaDagar(), HttpStatus.OK);
    }
    @GetMapping("framtidadatum")
    ResponseEntity<String> framtidaDatum(@RequestParam String start, @RequestParam int dagar) {
        LocalDate current = LocalDate.parse(start);
        for(int i=0; i < dagar; i++) {
            current = current.plusDays(1);
            boolean dagFinnsIListan = kalenderConfig.getRodaDagar().contains(current.toString());
            boolean dagArSondag = current.getDayOfWeek().equals(DayOfWeek.SUNDAY);
            while(dagFinnsIListan){
                current = current.plusDays(1);
            }
        }
        return new ResponseEntity<>(current.toString(), HttpStatus.OK);
    }
}
