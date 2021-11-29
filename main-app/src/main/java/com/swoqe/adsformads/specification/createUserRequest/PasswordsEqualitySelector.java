package com.swoqe.adsformads.specification.createUserRequest;

import com.swoqe.adsformads.security.dto.CreateUserRequest;
import com.swoqe.adsformads.specification.AbstractSelector;

import java.util.regex.Pattern;

public class PasswordsEqualitySelector extends AbstractSelector<CreateUserRequest> {

    @Override
    public boolean test(CreateUserRequest createUserRequest) {
        boolean equals = createUserRequest.getPassword().equals(createUserRequest.getRePassword());
        System.out.println(equals);
        return equals;
    }
}
