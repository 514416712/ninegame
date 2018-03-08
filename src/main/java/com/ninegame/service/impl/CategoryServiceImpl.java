package com.ninegame.service.impl;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ninegame.mapper.CategoryMapper;
import com.ninegame.pojo.Category;
import com.ninegame.pojo.CategoryExample;
import com.ninegame.service.CategoryService;
 
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;
 
    @Override
    public List<Category> list() {
        CategoryExample example =new CategoryExample();
        example.setOrderByClause("id desc");
        return categoryMapper.selectByExample(example);
    }
 
    @Override
    public void add(Category category) {
        categoryMapper.insert(category);
    }
 
    @Override
    public void delete(int id) {
        categoryMapper.deleteByPrimaryKey(id);
    }
 
    @Override
    public Category get(int id) {
        return categoryMapper.selectByPrimaryKey(id);
    }
 
    @Override
    public void update(Category category) {
        categoryMapper.updateByPrimaryKeySelective(category);
    }
}