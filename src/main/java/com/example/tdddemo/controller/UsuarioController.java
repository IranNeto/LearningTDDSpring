package com.example.tdddemo.controller;

import com.example.tdddemo.entities.User;
import com.example.tdddemo.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsuarios() {
        return new ResponseEntity<>(usuarioService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return new ResponseEntity<>(usuarioService.registerUser(user), HttpStatus.OK);
    }

}
