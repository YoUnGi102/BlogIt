package com.gres.tomas.businesstier.domain.dto;

public class CreateUserDto {

    private final String username;
    private final String password;
    private final String repeatPassword;
    private final String email;

    public CreateUserDto(String username, String password, String repeatPassword, String email) {
        this.username = username;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getRepeatPassword() {
        return repeatPassword;
    }
    public String getEmail() {
        return email;
    }
}
