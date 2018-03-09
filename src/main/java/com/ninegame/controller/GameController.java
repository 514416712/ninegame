package com.ninegame.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ninegame.pojo.Category;
import com.ninegame.pojo.Game;
import com.ninegame.service.CategoryService;
import com.ninegame.service.GameService;
import com.ninegame.util.ImageUtil;
import com.ninegame.util.Page;
import com.ninegame.util.UploadedImageFile;

@Controller
@RequestMapping("")
public class GameController {
	@Autowired
	CategoryService categoryService;

	@Autowired
	GameService gameService;

	@RequestMapping("admin_game_add")
	public String add(Model model, Game g, HttpSession session, UploadedImageFile uploadedImageFile) throws Exception {
		gameService.add(g);

		File imageFolder = new File(session.getServletContext().getRealPath("img/game"));
		File file = new File(imageFolder, g.getId() + ".jpg");
		if (!file.getParentFile().exists())
			file.getParentFile().mkdirs();
		uploadedImageFile.getImage().transferTo(file);
		BufferedImage img = ImageUtil.change2jpg(file);
		ImageIO.write(img, "jpg", file);

		return "redirect:admin_game_list?cid=" + g.getCid();
	}

	@RequestMapping("admin_game_delete")
	public String delete(int id,HttpSession session) {
		Game g = gameService.get(id);
		gameService.delete(id);

		File imageFolder = new File(session.getServletContext().getRealPath("img/category"));
		File file = new File(imageFolder, id + ".jpg");
		file.delete();

		return "redirect:admin_game_list?cid=" + g.getCid();
	}

	@RequestMapping("admin_game_edit")
	public String edit(Model model, int id) {
		Game g = gameService.get(id);
		Category c = categoryService.get(g.getCid());
		g.setCategory(c);
		model.addAttribute("g", g);
		return "admin/editGame";
	}

	@RequestMapping("admin_game_update")
	public String update(Game g) {
		gameService.update(g);

		return "redirect:admin_game_list?cid=" + g.getCid();
	}

	@RequestMapping("admin_game_list")
	public String list(int cid, Model model, Page page) {
		Category c = categoryService.get(cid);

		PageHelper.offsetPage(page.getStart(), page.getCount());
		List<Game> gs = gameService.list(cid);

		int total = (int) new PageInfo<>(gs).getTotal();
		page.setTotal(total);
		page.setParam("&cid=" + c.getId());

		model.addAttribute("gs", gs);
		model.addAttribute("c", c);
		model.addAttribute("page", page);

		return "admin/listGame";
	}
}
