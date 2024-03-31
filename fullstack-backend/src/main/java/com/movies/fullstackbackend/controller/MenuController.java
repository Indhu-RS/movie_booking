package com.movies.fullstackbackend.controller;

import com.movies.fullstackbackend.exception.UserNotFoundException;
import com.movies.fullstackbackend.model.Menu;
import com.movies.fullstackbackend.repository.MenuRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List; // Import the List class

@RestController
@CrossOrigin("http://localhost:3000")
public class MenuController {
    @Autowired
    private MenuRepository menuRepository; 

    //@ResponseBody
    @GetMapping("/menus")
    List<Menu> getAllMenus() {
        return menuRepository.findAll();
        //return new ResponseEntity<>(menus, HttpStatus.OK);
    }
    @PostMapping(value="/menu")
     Menu newMenu(@RequestBody Menu newMenu){

        return menuRepository.save(newMenu); 
    }

}




