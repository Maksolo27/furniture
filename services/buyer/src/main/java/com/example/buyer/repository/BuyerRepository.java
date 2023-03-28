package com.example.buyer.repository;


import com.example.buyer.entities.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerRepository extends CrudRepository<Buyer,Long> , JpaRepository<Buyer,Long> {}
