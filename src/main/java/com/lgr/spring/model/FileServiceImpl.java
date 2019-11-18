package com.lgr.spring.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lgr.spring.dto.FileDto;

@Service
public class FileServiceImpl implements IFileService{

	@Autowired
	private IFileDao dao;
	
	@Override
	public String searchFile(String seq) {
		return dao.searchFile(seq);
	}

	@Override
	public boolean insertFile(FileDto fDto) {
		return dao.insertFile(fDto);
	}

}
