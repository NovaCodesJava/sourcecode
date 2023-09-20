package com.example.spring.transaction.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.spring.transaction.demo.entity.PassengerInfo;

public interface PassengerInfoRepository extends CrudRepository<PassengerInfo, Long>{

}
