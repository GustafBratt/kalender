package com.cybercom.gustafbratt.kalender;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "kalender")
public class KalenderConfig {

    private List<String> rodaDagar;

    public List<String> getRodaDagar() {
        return Collections.unmodifiableList(rodaDagar);
    }

    public void setRodaDagar(List<String> rodaDagar) {
        this.rodaDagar = rodaDagar;
    }
}
