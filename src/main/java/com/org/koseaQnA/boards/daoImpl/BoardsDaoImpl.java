package com.org.koseaQnA.boards.daoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.org.koseaQnA.boards.dao.BoardsDao;
import com.org.koseaQnA.boards.dto.BoardsResponseDto;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BoardsDaoImpl implements BoardsDao{
	
	final private SqlSessionTemplate sqlSession;

	@Override
	public ArrayList<BoardsResponseDto> findAllBoards(Map<String, Integer> map) {
		
		List<BoardsResponseDto> list = sqlSession.selectList("Boards.findAllBoards", map);
		
		return (ArrayList<BoardsResponseDto>) list;
	}

	@Override
	public int findBoardsCount() {
		
		int count = sqlSession.selectOne("Boards.findBoardsCount");
		
		return count;
	}

}
