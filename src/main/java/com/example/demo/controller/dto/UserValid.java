package com.example.demo.controller.dto;

import javax.validation.constraints.Pattern;

public class UserValid {

    @Pattern(regexp = "(^[0-9]*$)", message = "숫자만 가능합니다.")
    private final String id;

    public UserValid(String id) {
        this.id = id;
    }

    public Long getId() {
        return Long.valueOf(id);
    }
}
