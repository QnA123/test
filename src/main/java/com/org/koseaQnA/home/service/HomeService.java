package com.org.koseaQnA.home.service;

import org.springframework.stereotype.Service;

import com.org.koseaQnA.home.dao.Dao;
import com.org.koseaQnA.home.domain.UsersDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HomeService {
	
	private final Dao dao;

	
	public UsersDTO homeTest() {
		
		
		return dao.hometest();
	}
	
}
