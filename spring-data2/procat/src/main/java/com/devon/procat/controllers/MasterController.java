package com.devon.procat.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.devon.procat.models.Category;
import com.devon.procat.models.Product;
import com.devon.procat.services.PService;

@Controller
@RequestMapping("/")
public class MasterController {
	private final PService pService;
	public MasterController(PService pService) {
		this.pService = pService;
	}
	
	@RequestMapping("")
	public String product(@ModelAttribute("product") Product product) {
		return "product.jsp";
	}
	@RequestMapping("/newProduct")
	public String newProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("Form did not submit had errors"+result.getFieldError("name"));
			return "product.jsp";
		}else {
			System.out.println(product);
			pService.addProduct(product);
		}
		return "redirect:/";
	}
	@RequestMapping("/category")
	public String category(@ModelAttribute("category") Category category) {
		return "category.jsp";
	}
	@RequestMapping("/newCategory")
	public String newCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("Form did not submit had errors"+result.getFieldError("name"));
			return "category.jsp";
		}else {
			pService.addCategory(category);
		}
		return("redirect:/category");
	}
	@RequestMapping("/products/{id}")
	public String showProduct(@PathVariable("id") Long id, Model model) {
		Product product = pService.findProduct(id);
		ArrayList<Category> cats = pService.allCats();
		List<Category> prodCat = pService.findProduct(id).getCategories();
		
		for(int i = 0; i < prodCat.size(); i++) {
			if(cats.contains(prodCat.get(i))) {
				cats.remove(prodCat.get(i));
			}
		}
		
		model.addAttribute("product", product);
		model.addAttribute("cats", cats);
		model.addAttribute("prodCat", prodCat);
		return "showProduct.jsp";
	}
	@RequestMapping(path="/addCat/{id}", method=RequestMethod.POST)
	public String addCat(@PathVariable("id") Long id, @RequestParam(value="category") Long catid, Model model) {
		Product pro = pService.findProduct(id);
		Category cat = pService.findCategory(catid);
		
		List<Category> catList = pro.getCategories();
		catList.add(cat);
		pro.setCategories(catList);
		
		pService.update(pro);
		System.out.println(pro.getCategories());
		
		return("redirect:/products/"+id);
	}
	@RequestMapping("/categories/{id}")
	public String showCat(@PathVariable("id") Long id, Model model) {
		Category cat = pService.findCategory(id);
		List<Product> allProducts = pService.allProducts();
		List<Product> products = pService.findCategory(id).getProducts();
		
		for(int i = 0; i < products.size(); i++) {
			if(products.contains(products.get(i))) {
				allProducts.remove(products.get(i));
			}
		}
		model.addAttribute("cat", cat);
		model.addAttribute("allProducts", allProducts);
		model.addAttribute("products", products);
		
		return "showCategory.jsp";
	}
	@RequestMapping(path="addPro/{id}", method=RequestMethod.POST)
	public String addPro(@PathVariable("id")Long catid, @RequestParam(value="product")Long proid) {
		Category cat = pService.findCategory(catid);
		Product pro = pService.findProduct(proid);
		
		List<Product> prolist = cat.getProducts();
		prolist.add(pro);
		cat.setProducts(prolist);
		pService.cUpdate(cat);
		
		return("redirect:/categories/"+catid);
	}
	
}
