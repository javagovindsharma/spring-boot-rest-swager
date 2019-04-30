package com.techprimers.repository;


import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import com.techprimers.model.Products;



@Component
public interface ProductsRepository extends JpaRepository<Products, String> {
	
	
	 // Example with positional params
	   @Modifying
	   @Transactional
	   @Query("update Products p set p.productName = :productName,p.productLine = :productLine,p.productScale = :productScale,p.productVendor = :productVendor,p.productDescription = :productDescription,p.quantityInStock = :quantityInStock,p.buyPrice = :buyPrice,p.MSRP = :MSRP where p.productCode = :productCode")
	   Integer setNewDescriptionForProduct(@Param("productCode") String productCode,@Param("productName") String productName,@Param("productLine") String productLine,@Param("productScale") String productScale,@Param("productVendor") String productVendor,@Param("productDescription") String productDescription,@Param("quantityInStock") int quantityInStock,@Param("buyPrice") double buyPrice,@Param("MSRP") double MSRP);
	   
	   
		
}