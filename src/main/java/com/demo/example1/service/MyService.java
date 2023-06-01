package com.demo.example1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.example1.entity.MyEntity;
import com.demo.example1.model.Emp;
import com.demo.example1.repository.MyRepository;

@Service
public class MyService {
		
	
	@Autowired 
	private MyRepository repo;
	
	public MyEntity saveEmp(Emp e) {
		MyEntity entity = new MyEntity();
		entity.setId(e.getId());
		entity.setName(e.getName());
		entity.setSal(e.getSalary());
		entity.setDesignation(e.getDesignation());
		return repo.save(entity);
	}
	public Optional<MyEntity> getById(Long id) {
		 return repo.findById(id);
		
	}
	public List<MyEntity> getAllDetails(){
		return repo.findAll();
	}
	
	public void deleteById(Long id) {
		repo.deleteById(id);
	}
	
	public MyEntity updateDetails(Emp e) {
		MyEntity entity = new MyEntity();
		entity.setId(e.getId());
		entity.setName(e.getName());
		entity.setSal(e.getSalary());
		entity.setDesignation(e.getDesignation());
		return repo.save(entity);
	}
	
	
}
