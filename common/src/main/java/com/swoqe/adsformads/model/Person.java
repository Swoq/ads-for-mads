package com.swoqe.adsformads.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.MappedSuperclass;

@EqualsAndHashCode(callSuper = true)
@Data
@MappedSuperclass
public class Person extends BaseSqlEntity {

    private String firstName;
    private String lastName;
    private String email;

}
