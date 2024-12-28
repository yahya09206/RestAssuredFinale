package com.yahya.pojo;

import lombok.*;

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
