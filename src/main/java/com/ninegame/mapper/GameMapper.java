package com.ninegame.mapper;

import com.ninegame.pojo.Game;
import com.ninegame.pojo.GameExample;
import java.util.List;

public interface GameMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Game g);

    int insertSelective(Game g);

    List<Game> selectByExample(GameExample example);

    Game selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Game g);

    int updateByPrimaryKey(Game g);
}