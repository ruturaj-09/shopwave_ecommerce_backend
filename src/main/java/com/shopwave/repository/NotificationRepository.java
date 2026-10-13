package com.shopwave.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopwave.model.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {



}
