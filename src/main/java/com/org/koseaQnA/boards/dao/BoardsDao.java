package com.org.koseaQnA.boards.dao;

import java.util.ArrayList;
import java.util.Map;

import com.org.koseaQnA.boards.dto.BoardsResponseDto;



public interface BoardsDao {
	
	ArrayList<BoardsResponseDto> findAllBoards(Map<String, Integer> map);

	int findBoardsCount(); 

}
