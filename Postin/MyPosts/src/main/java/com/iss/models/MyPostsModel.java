package com.iss.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MyPostsModel{
	@Id
	private int Id;
	private String Title;
	private String Category;
	private String Description;
	private byte[] Image;
	private String Location;
	private String CreatedBy;
	private String CreatedDate;
	private String Status;
	
	
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public int getId() {
		return Id;
	}
	public void setId(int Id) {
		this.Id = Id;
	}
	
	public String getTitle() {
		return Title;
	}
	public void setTitle(String Title) {
		this.Title = Title;
	}
	
	public String getCategory() {
		return Category;
	}
	public void setCategory(String Category) {
		this.Category = Category;
	}
	
	public String getDescription() {
		return Description;
	}
	public void setDescription(String Description) {
		this.Description = Description;
	}
	
	public byte[] getImage() {
		return Image;
	}
	public void setImage(byte[] imagebyte) {
		this.Image = imagebyte;
	}
	
	public String getLocation() {
		return Location;
	}
	public void setLocation(String Location) {
		this.Location = Location;
	}
	
	public String getCreatedBy() {
		return CreatedBy;
	}
	public void setCreatedBy(String CreatedBy) {
		this.CreatedBy = CreatedBy;
	}
	
	public String getCreatedDate() {
		return CreatedDate;
	}
	public void setCreatedDate(String CreatedDate) {
		this.CreatedDate = CreatedDate;
	}
}	
