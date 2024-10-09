package vn.iotstar.services;

import java.util.List;

import vn.iotstar.entity.Category;

public interface ICategoryService {
	 public int count();

	 public List<Category> findAll(int page, int pagesize);

	 public List<Category> findByCategoryname(String catname);

	 public List<Category> findAll();

	 public Category findById(int cateid);

	 public void delete(int cateid) throws Exception;

	 public void update(Category category);

	 public void insert(Category category);

}
