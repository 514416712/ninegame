package com.ninegame.controller;
 
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ninegame.pojo.Category;
import com.ninegame.service.CategoryService;
import com.ninegame.util.ImageUtil;
import com.ninegame.util.Page;
import com.ninegame.util.UploadedImageFile;
 
@Controller
@RequestMapping("")
public class CategoryController {
	 @Autowired
	    CategoryService categoryService;
	   
	 @RequestMapping("admin_category_list")
	 public String list(Model model,Page page){
	     PageHelper.offsetPage(page.getStart(),page.getCount());
	     List<Category> cs= categoryService.list();
	     int total = (int) new PageInfo<>(cs).getTotal();
	     page.setTotal(total);
	     model.addAttribute("cs", cs);
	     model.addAttribute("page", page);
	     return "admin/listCategory";
	 }
	    
	    @RequestMapping("admin_category_add")
	    public String add(Category c) throws IOException {
	        categoryService.add(c);
	        
	        return "redirect:/admin_category_list";
	    }
	    
	    @RequestMapping("admin_category_delete")
	    public String delete(int id) throws IOException {
	        categoryService.delete(id);
	     
	        return "redirect:/admin_category_list";
	    }
	    
	    @RequestMapping("admin_category_edit")
	    public String edit(int id,Model model) throws IOException {
	        Category c= categoryService.get(id);
	        model.addAttribute("c", c);
	        return "admin/editCategory";
	    }
	    
	    @RequestMapping("admin_category_update")
	    public String update(Category c) throws IOException {
	        categoryService.update(c);
	        return "redirect:/admin_category_list";
	    }
}