package com.example.Advisor.service;

import com.example.Advisor.model.Location;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class AdvisorService {

    @Value("${ipinfo.token}")
    private String ipinfoToken;

    public Location getLocation() {
        String url = "https://ipinfo.io/json?token=" + ipinfoToken;

        RestTemplate restTemplate = new RestTemplate();
        @SuppressWarnings("unchecked")
        Map<String, Object> response = restTemplate.getForObject(url, Map.class);

        if (response != null && response.containsKey("loc")) {
            String loc = (String) response.get("loc");
            Location location = new Location();
            location.setCoordinatesFromString(loc);
            return location;
        }

        return null; // or throw an exception or handle this case as needed
    }
}
