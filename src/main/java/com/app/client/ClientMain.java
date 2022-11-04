package com.app.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.app.config.ProjectConfig;
import com.app.service.ProductService;

public class ClientMain {

	public static void main(String[] args) {
		try(var context= new AnnotationConfigApplicationContext(ProjectConfig.class))
		{
			ProductService servicemsg = context.getBean(ProductService.class);
			String insertProduct = servicemsg.insertProduct();
			System.out.println(insertProduct);
                
		}
	}
}
