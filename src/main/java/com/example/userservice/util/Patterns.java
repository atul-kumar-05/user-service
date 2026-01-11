package com.example.userservice.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Patterns {
    public static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    public static final String PHONE_REGEX = "^\\+?[1-9]\\d{1,14}$";
}
