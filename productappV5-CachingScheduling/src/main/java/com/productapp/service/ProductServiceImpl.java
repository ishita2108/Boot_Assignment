package com.productapp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.productapp.exceptions.ProductNotFoundException;
import com.productapp.repository.Product;
import com.productapp.repository.ProductDao;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	private ProductDao productDao;
	private Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	public ProductServiceImpl(ProductDao productDao) {
		this.productDao = productDao;
	}
	@Cacheable("products")
	@Override
	public List<Product> findAll() {
		logger.info("==================Find all==============");
		return productDao.findAll();
	}
	
	@Cacheable(value ="products",key ="#id")
	@Override
	public Product getById(int id) {
		logger.info("==================Find By Id==============");
		return productDao.findById(id)
				.orElseThrow(() -> new ProductNotFoundException("product with id" + id + " is not found"));
	}
	@CachePut(value ="products",key ="#result.id")
	@Override
	public Product addProduct(Product product) {
		productDao.save(product);
		return product;
	}
	@CachePut(value ="products",key ="#result.id")
	@Override
	public Product updateProduct(int id, Product product) {
		Product productToUpdate= getById(id);
		productToUpdate.setPrice(product.getPrice());
		productDao.save(productToUpdate);
		return productToUpdate;
	}
	@CacheEvict(value ="products",key ="#id")
	@Override
	public Product deleteProduct(int id) {
		Product productToDelete= getById(id);
		productDao.delete(productToDelete);
		return productToDelete;
	}
	@CacheEvict(value="products", key="#id")
	@Override
	public void evictCache() {

		
	}

}
