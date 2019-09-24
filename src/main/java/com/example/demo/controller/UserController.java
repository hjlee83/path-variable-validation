package com.example.demo.controller;

import com.example.demo.controller.dto.UserValid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Validated
@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    @GetMapping("{id}")
    public ResponseEntity<Long> getUser(@PathVariable(name = "id") @Valid UserValid userValid) {

        return ResponseEntity.ok(userValid.getId());
    }
}
