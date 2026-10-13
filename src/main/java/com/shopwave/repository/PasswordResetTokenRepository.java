package com.shopwave.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopwave.model.PasswordResetToken;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Integer> {
	PasswordResetToken findByToken(String token);
}
