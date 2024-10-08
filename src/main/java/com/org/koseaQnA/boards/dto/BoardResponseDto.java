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
 *	contents	->	글 내용
 *	hit			->	조회수
 *	category	->	카테고리
 *	created_at 	->  글 작성일
 *	updated_at 	->  글 수정
 *	user_id		->	유저 아이디
 */

@Data
public class BoardResponseDto {
	
	private long id;
	private String title;
	private String contents;
	private String hit;
	private String category;
	private String created_at;
	private String updated_at;
	private String user_id;

}
