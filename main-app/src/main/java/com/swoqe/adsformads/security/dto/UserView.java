package com.swoqe.adsformads.security.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class UserView {

    private UUID id;
    private String username;

}
