package com.swoqe.adsformads;

import lombok.Data;


@Data
public class ResourceRoot<T> {
    public Embedded<T> _embedded;
    public Page page;
}



