package com.example.storage.repository;


import com.example.storage.entity.Ware;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageRepository extends CrudRepository<Ware, Long>, JpaRepository<Ware, Long> {


}