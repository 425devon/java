package com.devon.procat.services;

import java.util.Date;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.devon.procat.models.Category;
import com.devon.procat.models.Product;
import com.devon.procat.repositories.CRepo;
import com.devon.procat.repositories.PRepo;

@Service
public class PService {
	private PRepo pRepo;
	private CRepo cRepo;
	
	public PService(PRepo pRepo, CRepo cRepo) {
		this.pRepo = pRepo;
		this.cRepo = cRepo;
	}
	
	public ArrayList<Product> allProducts(){
		return pRepo.findAll();
	}
	public ArrayList<Category> allCats(){
		return cRepo.findAll();
	}
	public void addProduct(Product product) {
		pRepo.save(product);
	}
	public void addCategory(Category category) {
		cRepo.save(category);
	}
	public Product findProduct(Long id) {
		return pRepo.findById(id).orElse(null);
	}
	public Category findCategory(Long id) {
		return cRepo.findById(id).orElse(null);
	}
	public void update(Product product) {
		product.setUpdatedAt(new Date());
		pRepo.save(product); 
	}
	public void cUpdate(Category category) {
		category.setUpdatedAt(new Date());
		cRepo.save(category);
	}


}
