package com.org.koseaQnA.home.daoImpl;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.org.koseaQnA.home.dao.Dao;
import com.org.koseaQnA.home.domain.UsersDTO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class DaoImpl implements Dao {
	
	final private SqlSessionTemplate sqlSession;

	@Override
	public UsersDTO hometest() {
	    return sqlSession.selectOne("Users.selectUsersById", 1L); 
	}

}
