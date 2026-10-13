package com.shopwave.service;

import com.shopwave.exception.SellerException;
import com.shopwave.exception.UserException;
import com.shopwave.request.LoginRequest;
import com.shopwave.request.SignupRequest;
import com.shopwave.response.AuthResponse;
import jakarta.mail.MessagingException;

public interface AuthService {

    void sentLoginOtp(String email) throws UserException, MessagingException;
    String createUser(SignupRequest req) throws SellerException;
    AuthResponse signin(LoginRequest req) throws SellerException;

}
