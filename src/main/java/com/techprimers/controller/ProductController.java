package com.techprimers.controller;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import com.techprimers.model.Products;
import com.techprimers.service.ErrorDetails;
import com.techprimers.service.ProductService;

@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService productService;

	@PostMapping("/all")
	public List<Products> getAllUser(HttpServletRequest request,HttpServletResponse response) {
		logger.info("get All product"+productService.getAllUsers());		
		return productService.getAllUsers();
	}
	@GetMapping(value = "/testAll")
	public List<Products> getTestAllUser(HttpServletRequest request,HttpServletResponse response) {
		logger.info("get All product"+productService.getAllUsers());		
		return productService.getAllUsers();
	}

	@PostMapping(value = "/add-product")
	public void addUser(@RequestBody Products userRecord) {
		productService.addUser(userRecord);
	}
	
	@PostMapping(value = "/update-product")
	public void updateProductById(@RequestBody Products userRecord) {
		productService.updateProduct(userRecord);
		System.out.println("DONE "+userRecord.toString());
	}
	
	@GetMapping(value = "/test")
	public String  checkRequest() {
		return "Welcome Test done";
	}

	@PostMapping(value = "/{id}")
	public Products getUser(@PathVariable String id) {
		return productService.getUser(id);
	}
	
	@PostMapping(value = "/delete/{id}")
	public void deleteProduct(@PathVariable String id) {
		 productService.delete(id);
	}
	
	
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request) {
	  ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
	      request.getDescription(false));
	  return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
	
	
}