package com.techprimers.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.techprimers.model.Employee;
import com.techprimers.model.Products;
import com.techprimers.service.JoinTableService;
import com.techprimers.service.ProductService;

@CrossOrigin
@RestController
@RequestMapping("/")
public class JoinTableController {
	
	@Autowired
	private JoinTableService joinTableService;

	@Autowired
	private ProductService productService;
	
	@PostMapping("all")
	public List<Employee> getAllOffice(HttpServletRequest request,HttpServletResponse response) {
		return joinTableService.getAllEmployeeWithOfficeService();
	}
	
	

	@GetMapping("all1")
	public List<Products> getAllEmplpyee(HttpServletRequest request,HttpServletResponse response) {
		 return productService.getAllUsers();
	}
}
