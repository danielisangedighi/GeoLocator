package com.example.Advisor;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import com.example.Advisor.model.Location;
import com.example.Advisor.service.AdvisorService;

@RunWith(MockitoJUnitRunner.class)
public class AdvisorServiceTest {
    
    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private AdvisorService advisorService;

    @Test
    public void getLocation() {
        // Arrange
        String url = "https://ipinfo.io/json?token=62c0a36c3bd7da"; 
        Map<String, Object> mockResponse = new HashMap<>();
        mockResponse.put("loc", "37.7749,-122.4194");

        when(restTemplate.getForObject(url, Map.class)).thenReturn(mockResponse);
        
        // Act
        Location location = advisorService.getLocation();

        // Assert
        assertEquals(37.7749, location.getLatitude(), 0.0001);
        assertEquals(-122.4194, location.getLongitude(), 0.0001);
    }

}
/*
 The test will fail because org.springframework.web.client.HttpClientErrorException$NotAcceptable: 
 406 Not Acceptable: "{"error": 406, "data": 
 "I believe you've received this request in error, please open a support request."}[EOL]"
 */