package cn.liuyiyou.yishop.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.liuyiyou.yishop.entity.Product;

public class ProductServiceTest extends AbstractServiceTest {
	
	@Autowired
	private ProductService productService;
	
	

	@Test
	public void queryByConditionForPageTest(){
		List<Product> products = productService.findProductsForIndex("数码家电", 0, 16);
		for(Product product:products){
			System.out.println("xx"+product.getProdName());
		}
	}
	
}
