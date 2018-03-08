package com.ninegame.service;
import java.util.List;

import com.ninegame.pojo.Category;
import com.ninegame.util.Page;
public interface CategoryService{
		List<Category> list();
	 
	    void add(Category category);
	 
	    void delete(int id);
	 
	    Category get(int id);
	 
	    void update(Category category);
}