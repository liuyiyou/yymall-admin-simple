package cn.liuyiyou.yishop.mapper;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.liuyiyou.yishop.entity.Product;

public class ProductMapperTest extends AbstractMapperTest {

	@Autowired
	private ProductMapper productMapper;
	
	@Test
	public void queryByConditionForPageTest(){
		
		List<Product> products = productMapper.queryByConditionForPage("数码家电",null, 0, 16);
		for(Product product:products){
			System.out.println("xx"+product.getProdName());
		}
	}
	
	@Test
	public void queryAllTest(){
		
		List<Product> products = productMapper.queryAll();
		for(Product product:products){
			System.out.println(product.getProdName());
		}
	}
	
	@Test
	public void countByChannelTest(){
		System.out.println("刘易友");
		int channel = productMapper.countByChannel("数码家电");
		System.out.println(channel);
	}
}
