package com.demo.example1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.example1.entity.MyEntity;
import com.demo.example1.model.Emp;

@Repository
public interface MyRepository extends JpaRepository<MyEntity, Long> {

	
		
	
	
}
