package com.yahya.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Car {

    private String model;
    private String make;
    private int year;
    private boolean autopilot;
}
