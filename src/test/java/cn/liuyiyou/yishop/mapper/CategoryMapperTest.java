package cn.liuyiyou.yishop.mapper;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.liuyiyou.yishop.entity.Category;

/**
 * 类目测试
 * 
 * @author liuyiyou
 *
 */
public class CategoryMapperTest extends AbstractMapperTest {

	@Autowired
	private CategoryMapper categoryMapper;

	@Test
	public void getAllCategory() {
		List<Category> categories = categoryMapper.queryByParentIdAndStatus(0,
				"1");
		for (Category category : categories) {
			System.out.println(category.getNameCn());
			{
				System.out.println("\t"+category.getNameCn());
				List<Category> secondCategories = categoryMapper
						.queryByParentIdAndStatus(category.getId(), "1");
				for (Category secondCategory : secondCategories) {
					System.out.println("\t\t" + secondCategory.getNameCn());
					List<Category> thridCategories = categoryMapper
							.queryByParentIdAndStatus(secondCategory.getId(), "1");
					for(Category thirdCategory: thridCategories){
						System.out.println("\t\t\t"+ thirdCategory.getNameCn());
					}
				}
			}
		}
	}
}
