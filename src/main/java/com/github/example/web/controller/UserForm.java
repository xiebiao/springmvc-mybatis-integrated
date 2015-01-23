package com.github.example.web.controller;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * @author xiebiao
 */
public class UserForm {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull(message = "用户名不能为空：User's name can't be Null")
    @NotBlank(message = "用户名不能为空")
    private String name;
}
