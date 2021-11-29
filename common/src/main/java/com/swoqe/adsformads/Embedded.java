package com.swoqe.adsformads;

import lombok.Data;

import java.util.List;

@Data
public class Embedded<T> {
    public List<T> data;
}
