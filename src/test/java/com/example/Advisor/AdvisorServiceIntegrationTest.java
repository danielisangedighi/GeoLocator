package com.example.Advisor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.example.Advisor.model.Location;
import com.example.Advisor.service.AdvisorService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdvisorServiceIntegrationTest {
    
    @Autowired
    private AdvisorService advisorService;

    @MockBean
    private RestTemplate restTemplate;

    @Test
    public void testGetLocation() {
        // Arrange
        String mockResponse = "{ \"loc\": \"37.7749,-122.4194\" }";
        String url = "https://ipinfo.io/json?token=62c0a36c3bd7da"; 

        // Mock the RestTemplate to return the mocked response
        when(restTemplate.getForObject(url, String.class)).thenReturn(mockResponse);
        
        // Act
        Location location = advisorService.getLocation();

        // Assert
        assertNotNull("Location should not be null", location);
        assertEquals(37.7749, location.getLatitude(), 0.0001);
        assertEquals(-122.4194, location.getLongitude(), 0.0001);
    }
}
