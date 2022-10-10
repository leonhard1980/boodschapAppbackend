package com.example.demo.dto;


import java.util.Date;

public class UserDto extends AuthDto {
    public Long[] roleIds;
    public String[] roleNames[];
    public Date BirthDate;
    public String emailAddress;
    public String postcode;
    public int houseNumber;
    public String City;
    public boolean hasNewsLetter;
    public boolean hasApproved;
    public Date registrationDate;
}


