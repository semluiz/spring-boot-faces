package com.auth0.samples.bootfaces.controller;

import com.auth0.samples.bootfaces.ProductRepository;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "session") //single intance that will persist per user
@Component(value = "productController") //spring component that will be used in the form intervae
@ELBeanName(value = "producController") // configure the bean name
@Join(path = "/product", to ="/product-form.jsf") //configure the url to respond with the content
public class ProductController {
	@Autowired
	private ProductRepository productRepository;

	private Product product = new Product();



	public String save(){
		productRepository.save(product);

		product = new Product();

		return "/product-list.html?faces-redirect=true";
	}

	public Product getProduct(){
		return product;
	}

}
