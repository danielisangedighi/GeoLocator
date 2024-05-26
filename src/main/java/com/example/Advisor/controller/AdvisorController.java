package com.example.Advisor.controller;

//import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.Advisor.model.Credential;
import com.example.Advisor.model.Location;
import com.example.Advisor.service.AdvisorService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;


//@RestController
//@RequestMapping("/location")
@Controller
public class AdvisorController {

    //Injecting AdvisoryService dependency class
    @Autowired
    private AdvisorService advisorService;

    @GetMapping
    public ResponseEntity<Location> getLocation() {
        Location location = advisorService.getLocation();
        if (location != null) {
            return ResponseEntity.ok(location);
        } else {
            return ResponseEntity.status(500).body(null);
        }
    }

    List <Credential> credentials = new ArrayList<>();

    @GetMapping("/login")
    public String getLoginForm(Model model) {
        model.addAttribute("credential", new Credential());
        return "login";
    }

    @PostMapping("/submitLogin")
    public String handleLogin(Credential credential) {
        //Login POST request adds credentials
        credentials.add(credential);
        return "redirect:/home";
    }
    

    @GetMapping("/home")
    public String getHome(Model model) {
        //String usersname = Credential.getUsername();
        //model.addAttribute("message", "username");
        model.addAttribute("username", Credential.getUsername());
        return "home";
    }

    @PostMapping("/getAdvise")
    public String getAdvise(Location location) {
        return "redirect:/view";
    }
    
    @GetMapping("/view")
    public String getLocation(Model model) {
        Location location = advisorService.getLocation();
        model.addAttribute("location", location);
        return "view";
    }
}
