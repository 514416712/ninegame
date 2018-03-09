package com.ninegame.service.impl;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ninegame.mapper.CategoryMapper;
import com.ninegame.mapper.GameMapper;
import com.ninegame.pojo.Category;
import com.ninegame.pojo.CategoryExample;
import com.ninegame.pojo.Game;
import com.ninegame.pojo.GameExample;
import com.ninegame.service.CategoryService;
import com.ninegame.service.GameService;
 
@Service
public class GameServiceImpl implements GameService {
	@Autowired
    GameMapper gameMapper;
    @Autowired
    CategoryService categoryService;
	@Override
	public void add(Game g) {
		gameMapper.insert(g);
	}
	@Override
	public void delete(int id) {
		gameMapper.deleteByPrimaryKey(id);
	}
	@Override
	public void update(Game g) {
		gameMapper.updateByPrimaryKey(g);
	}
	@Override
	public Game get(int id) {
		Game g = gameMapper.selectByPrimaryKey(id);
		setGame(g);
		return g;
	}
	private void setGame(List<Game> gs) {
		for (Game g : gs) {
			setGame(g);
		}
		
	}
	private void setGame(Game g) {
		int cid = g.getCid();
		Category c = categoryService.get(cid);
		g.setCategory(c);
	}
	@Override
	public List list(int cid) {
		GameExample example = new GameExample();
		example.createCriteria().andCidEqualTo(cid);
		example.setOrderByClause("id desc");
		List  result = gameMapper.selectByExample(example);
		setGame(result);
		return result;
	}
	
}