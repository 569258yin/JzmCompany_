package com.jinzhimu.company.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="news")
public class News {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@NotNull
	private String title;
	@NotNull
	private String text;
	private String auther;
	private String source;
	@NotNull
	private Date sendTime;
	private long visiterNum;
	
	public News() {
	}
	public News(String title, String text, String auther, String source, Date sendTime, long visiterNum) {
		super();
		this.title = title;
		this.text = text;
		this.auther = auther;
		this.source = source;
		this.sendTime = sendTime;
		this.visiterNum = visiterNum;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getAuther() {
		return auther;
	}
	public void setAuther(String auther) {
		this.auther = auther;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	public long getVisiterNum() {
		return visiterNum;
	}
	public void setVisiterNum(long visiterNum) {
		this.visiterNum = visiterNum;
	}
	
	
	
	
	
}
