package com.example.spring.transaction.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.spring.transaction.demo.entity.PaymentInfo;

public interface PaymentInfoRepository extends CrudRepository<PaymentInfo, String>{

}
