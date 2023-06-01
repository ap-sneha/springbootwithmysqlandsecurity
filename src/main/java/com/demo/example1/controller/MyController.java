package com.demo.example1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.example1.entity.MyEntity;
import com.demo.example1.model.Emp;
import com.demo.example1.service.MyService;

@RestController
@RequestMapping(value="/rest")
public class MyController {
		
	@Autowired
	private MyService service;
	
	
	
	@PostMapping("/save")
	public ResponseEntity saveDetails(@RequestBody Emp e) {
		service.saveEmp(e);
		
		return new ResponseEntity<>("successfully saved the data",HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getById")
	public Optional<MyEntity> getByIdController(@RequestParam Long id) {
		return service.getById(id);
	}
	
	@GetMapping("/getAllDetails")
	public List<MyEntity> getAll() {
		return service.getAllDetails();
	}
	
	@DeleteMapping("/deleteById")
	public void deleteByIdController(@RequestParam Long id) {
		service.deleteById(id);
	}
	
	@PutMapping("/update")
	public ResponseEntity update(@RequestBody Emp e) {
		service.updateDetails(e);
		return new ResponseEntity<>("successfully updated the given data",HttpStatus.CREATED);
	}
}
