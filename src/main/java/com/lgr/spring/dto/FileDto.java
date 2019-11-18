package com.lgr.spring.dto;

import java.io.Serializable;

public class FileDto implements Serializable{
	
	private static final long serialVersionUID = 3722193840845211581L;
	private String seq;
	private String ogfilename;
	 private String sgfilename;
	 private String size;
	 private String type;
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getOgfilename() {
		return ogfilename;
	}
	public void setOgfilename(String ogfilename) {
		this.ogfilename = ogfilename;
	}
	public String getSgfilename() {
		return sgfilename;
	}
	public void setSgfilename(String sgfilename) {
		this.sgfilename = sgfilename;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	 public FileDto() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "FileDto [seq=" + seq + ", ogfilename=" + ogfilename + ", sgfilename=" + sgfilename + ", size=" + size
				+ ", type=" + type + "]";
	}
	public FileDto(String seq, String ogfilename, String sgfilename, String size, String type) {
		super();
		this.seq = seq;
		this.ogfilename = ogfilename;
		this.sgfilename = sgfilename;
		this.size = size;
		this.type = type;
	}
	 
	 
	 
}
