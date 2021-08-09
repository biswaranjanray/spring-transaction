package com.spring.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.transaction.entity.PassengerInfo;

public interface PassengerInfoRepository extends JpaRepository<PassengerInfo, Long> {

}
