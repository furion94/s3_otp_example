package com.lgr.spring.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lgr.spring.dto.FileDto;

@Repository
public class FileDaoImpl implements IFileDao{
	
	@Autowired
	private SqlSessionTemplate session;
	
	private static final String NS = "com.lgr.spring.model.IFileDao.";

	@Override
	public String searchFile(String seq) {
		return session.selectOne(NS+"searchFile",seq);
	}

	@Override
	public boolean insertFile(FileDto fDto) {
		return session.insert(NS+"insertFile",fDto)>0?true:false;
	}

}
