package com.cybercom.gustafbratt.kalender;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "kalender")
public class KalenderConfig {

    private List<String> rodaDagar;

    public List<String> getRodaDagar() {
        return rodaDagar;
    }

    public void setRodaDagar(List<String> fileTypes) {
        this.rodaDagar = fileTypes;
    }
}
