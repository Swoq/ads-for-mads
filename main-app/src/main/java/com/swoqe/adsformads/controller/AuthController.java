package com.swoqe.adsformads.controller;

import com.swoqe.adsformads.security.SecurityUser;
import com.swoqe.adsformads.security.SecurityUserService;
import com.swoqe.adsformads.security.dto.AuthRequest;
import com.swoqe.adsformads.security.dto.AuthResponse;
import com.swoqe.adsformads.security.dto.CreateUserRequest;
import com.swoqe.adsformads.security.dto.UserView;
import com.swoqe.adsformads.security.jwt.JwtTokenUtil;
import com.swoqe.adsformads.specification.createUserRequest.CredentialsRegularExpressionSelector;
import com.swoqe.adsformads.specification.createUserRequest.PasswordsEqualitySelector;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping(path = "api/")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final SecurityUserService securityUserService;

    @PostMapping("login")
    public ResponseEntity<AuthResponse> login(@RequestBody @Valid AuthRequest request, HttpServletResponse response) {
        try {
            Authentication authenticate = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

            SecurityUser user = (SecurityUser) authenticate.getPrincipal();

            String token = jwtTokenUtil.generateAccessToken(user);
            AuthResponse authResponse = new AuthResponse(token, user.getId());

            response.addCookie(new Cookie(HttpHeaders.AUTHORIZATION, token));
            return ResponseEntity.ok()
                    .body(authResponse);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("registration")
    public UserView register(@RequestBody CreateUserRequest request) {
        var criteria = new CredentialsRegularExpressionSelector()
                .and(new PasswordsEqualitySelector());
        boolean validation = criteria.test(request);
        if (!validation) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Validate your request!");
        }
        return securityUserService.create(request);
    }

}