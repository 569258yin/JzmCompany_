package com.jinzhimu.company.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="goods")
public class Goods {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	//商品内部编号
	private String goodsNum;
	private long categoryId;
	private String name;
	private String text;
	private String price;
	private long visiterNum;
	private Date sendTime;
	private Date publishTime;
	private String icon;
	//材质
	private String material;
	//调性
	private String tone;
	//垂钓场地
	private String fishingGrounds;
	//重量
	private float weight;
	//节数
	private int pointNum;
	//长度
	private int length;
	//先经
	private int xianJing;
	//元经
	private int yuanJing;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(String goodsNum) {
		this.goodsNum = goodsNum;
	}
	
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public long getVisiterNum() {
		return visiterNum;
	}
	public void setVisiterNum(long visiterNum) {
		this.visiterNum = visiterNum;
	}
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	public Date getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getTone() {
		return tone;
	}
	public void setTone(String tone) {
		this.tone = tone;
	}
	public String getFishingGrounds() {
		return fishingGrounds;
	}
	public void setFishingGrounds(String fishingGrounds) {
		this.fishingGrounds = fishingGrounds;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public int getPointNum() {
		return pointNum;
	}
	public void setPointNum(int pointNum) {
		this.pointNum = pointNum;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getXianJing() {
		return xianJing;
	}
	public void setXianJing(int xianJing) {
		this.xianJing = xianJing;
	}
	public int getYuanJing() {
		return yuanJing;
	}
	public void setYuanJing(int yuanJing) {
		this.yuanJing = yuanJing;
	}
	
	
	
	
}
