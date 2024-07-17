package com.iss.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MyFriendsPostModel{
	@Id
	private String Title;
	private String Category;
	private String Description;
    private String Location;
	private byte[] Image;


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
	
	public String getLocation() {
		return Location;
	}
	public void setLocation(String Location) {
		this.Location = Location;
	}
	
    public byte[] getImage() {
		return Image;
	}
	public void setImage(byte[] imagebyte) {
		this.Image = imagebyte;
	}
}