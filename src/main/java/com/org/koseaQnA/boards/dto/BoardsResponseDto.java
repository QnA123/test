package com.org.koseaQnA.boards.dto;

import lombok.Data;

/**
 * 
 * @author kokoa223
 *
 *	boards 테이블
 *
 *	id			->	게시판 아이디
 *	title		->	글 제목
 *	hit			->	조회수
 *	created_at 	->  글 작성일
 *	user_name	->	작성자 이름
 */

@Data
public class BoardsResponseDto {
	
	private long id;
	private String title;
	private String hit;
	private String created_at;
	private String user_name;

}
