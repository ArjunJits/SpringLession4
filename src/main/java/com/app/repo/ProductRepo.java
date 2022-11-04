package com.app.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepo {
   @Autowired
	private JdbcTemplate jdbcTemplate;
   
   String insertSQL="insert into product(pid,productname,productprice) values(1,\"Lux\",100.0)";
   
   public String insertProduct() {
	   int success = jdbcTemplate.update(insertSQL);
	   return success >= 1 ? "inserted":"insertion failed";
   }
   
   
}
