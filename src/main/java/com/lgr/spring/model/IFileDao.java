package com.lgr.spring.model;

import com.lgr.spring.dto.FileDto;

public interface IFileDao {
	public String searchFile(String seq);
	public boolean insertFile(FileDto fDto);
}
