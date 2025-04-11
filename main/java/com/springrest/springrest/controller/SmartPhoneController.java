package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

import com.springrest.springrest.entities.SmartPhone;
import com.springrest.springrest.services.SmartPhoneService;

@RestController
@CrossOrigin("*")
public class SmartPhoneController {

    @Autowired
    private SmartPhoneService smartPhoneService;
    
    @GetMapping("/home")
    public String home() {
        return "Welcome to the SmartPhone API!";
    }
    
    // Get all smartPhones
    @GetMapping("/smartPhones")
    public ResponseEntity<List<SmartPhone>> getAllSmartPhones() {
        try {
            List<SmartPhone> phones = smartPhoneService.getAllSmartPhones();
            
            if (phones.isEmpty()) { 
                return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
            }
            
            return new ResponseEntity<>(phones, HttpStatus.OK); 
        } catch (Exception e) {
            e.printStackTrace(); // Log the error
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // Get smartPhone by ID
    @GetMapping("/smartPhones/{smartPhoneId}")
    public ResponseEntity<SmartPhone> getSmartPhoneById(@PathVariable Long smartPhoneId) {
        SmartPhone phone = smartPhoneService.getSmartPhoneById(smartPhoneId);
        if (phone != null) {
            return new ResponseEntity<>(phone, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Add new smartPhone
    @PostMapping("/smartPhones")
    public ResponseEntity<SmartPhone> addSmartPhone(@RequestBody SmartPhone phone) {
        try {
            SmartPhone savedPhone = smartPhoneService.saveSmartPhone(phone);
            return new ResponseEntity<>(savedPhone, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace(); // Log error details
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // Update smartPhone
    @PutMapping("/smartPhones")
    public ResponseEntity<SmartPhone> updateSmartPhone(@RequestBody SmartPhone phone) {
        SmartPhone updatedPhone = smartPhoneService.updateSmartPhone(phone);
        if (updatedPhone != null) {
            return new ResponseEntity<>(updatedPhone, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
   
    // Delete smartPhone by ID
    @DeleteMapping("/smartPhones/{smartPhoneId}")
    public ResponseEntity<HttpStatus> deleteSmartPhone(@PathVariable Long smartPhoneId) {
        try {
            smartPhoneService.deleteSmartPhone(smartPhoneId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
