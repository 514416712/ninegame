package com.ninegame.service;
import java.util.List;

import com.ninegame.pojo.Category;
import com.ninegame.pojo.Game;
import com.ninegame.util.Page;
public interface GameService{
	 void add(Game g);
	    void delete(int id);
	    void update(Game g);
	    Game get(int id);
	    List list(int cid);
}