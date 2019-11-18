package com.lgr.spring.ctrl;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.lgr.spring.dto.FileDto;
import com.lgr.spring.dto.S3FileUpload;
import com.lgr.spring.model.IFileService;

@Controller
public class HomeController {
	
	@Autowired
	private IFileService service;
	@Autowired
	private S3FileUpload s3;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		logger.info("Welcome home! The client locale is {}.");
		
		return "FileForm";
	}
	
	@RequestMapping(value = "/insert.do", method = RequestMethod.POST)
	public String insertFile(MultipartFile file, HttpServletRequest request) throws IllegalStateException, IOException {
		logger.info("파일 업로드");
		String ogName = file.getOriginalFilename();
		String fileType = ogName.substring(ogName.length()-3, ogName.length());
		String sgName = UUID.randomUUID()+"."+fileType;
		
		if(file.getSize() > 3145728) { // 파일 사이즈 3MB 이상일 경우 업로드 불가
			return "error";
		}else if(!fileType.equalsIgnoreCase("jpg") && !fileType.equalsIgnoreCase("png")) { // 파일 형식이 jpg거나 png만 업로드 가능
			return "error";
		}
		
		File conv = new File(sgName);
		file.transferTo(conv); // MultipartFile -> File
		s3.uploadFile(conv);
		
		return "ShowFile";
	}
	
}
