package com.org.koseaQnA.boards.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.org.koseaQnA.boards.dao.BoardsDao;
import com.org.koseaQnA.boards.dto.BoardsResponseDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardsService {
	
	final private BoardsDao boardsDao;
	
	public ArrayList<BoardsResponseDto> findAllBoards(int i, int amount) {
		
		Map<String, Integer> map = new HashMap();
		map.put("pNum", i);
		map.put("scale", amount);
		
		return boardsDao.findAllBoards(map);
	}

	public int findAllboardsCount() {
		return boardsDao.findBoardsCount();
	}

}
