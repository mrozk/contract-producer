package com.example.demo.rest;

import org.springframework.stereotype.Service;

@Service
public class EvenOddService {

    public String calculate(Integer number) {

        return number % 2 == 0 ? "Even" : "Odd";
    }
}
