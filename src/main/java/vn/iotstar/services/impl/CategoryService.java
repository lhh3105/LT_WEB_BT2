package vn.iotstar.services.impl;

import java.util.List;

import vn.iotstar.Dao.ICategoryDao;
import vn.iotstar.Dao.impl.CategoryDaoImpl;
import vn.iotstar.entity.Category;
import vn.iotstar.services.ICategoryService;

public class CategoryService implements ICategoryService {
	
	ICategoryDao cateDao = new CategoryDaoImpl();
	@Override
	public int count() {
		
		return cateDao.count();
	}

	@Override
	public List<Category> findAll(int page, int pagesize) {
		
		return cateDao.findAll();
	}

	@Override
	public List<Category> findByCategoryname(String catname) {
		// TODO Auto-generated method stub
		return cateDao.findByCategoryname(catname);
	}

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return cateDao.findAll();
	}

	@Override
	public Category findById(int cateid) {
		// TODO Auto-generated method stub
		return cateDao.findById(cateid);
	}

	@Override
	public void delete(int cateid) throws Exception {
		// TODO Auto-generated method stub
		cateDao.delete(cateid);
	}

	@Override
	public void update(Category category) {
		// TODO Auto-generated method stub
		cateDao.update(category);
		
	}

	@Override
	public void insert(Category category) {
		// TODO Auto-generated method stub
		cateDao.insert(category);
	}
	
}
