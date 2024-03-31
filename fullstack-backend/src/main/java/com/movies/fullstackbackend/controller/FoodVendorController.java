package com.movies.fullstackbackend.controller;

import com.movies.fullstackbackend.exception.UserNotFoundException;
import com.movies.fullstackbackend.model.FoodVendor;
import com.movies.fullstackbackend.repository.FoodVendorRepository;
import com.movies.fullstackbackend.model.Menu;
import com.movies.fullstackbackend.model.Movie;
//import com.movies.fullstackbackend.repository.FoodVendorRepository;
import com.movies.fullstackbackend.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.List; // Import the List class

@RestController
@CrossOrigin("http://localhost:3000")
public class FoodVendorController {
    @Autowired
    private FoodVendorRepository foodVendorRepository; 

    @Autowired
    private MenuRepository menuRepository;
    //@ResponseBody
    @GetMapping("/foodvendors")
    List<FoodVendor> getAllVendors() {
        return foodVendorRepository.findAll();
        //return new ResponseEntity<>(menus, HttpStatus.OK);
    }
   
    @GetMapping("/foodvendors/{vendorId}")
    ResponseEntity<FoodVendor> getVendorById(@PathVariable Long vendorId) {
        Optional<FoodVendor> vendor = foodVendorRepository.findById(vendorId);
        if (vendor.isPresent()) {
            return ResponseEntity.ok(vendor.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value="/foodvendor")
    FoodVendor newvendor(@RequestBody FoodVendor newvendor){

        return foodVendorRepository.save(newvendor); 
    }

}




