package com.spring.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.transaction.entity.PaymentInfo;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfo, String>{

}
