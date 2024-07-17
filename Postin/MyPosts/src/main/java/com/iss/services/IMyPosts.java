package com.iss.services;

import java.util.List;

import com.iss.models.MyPostsModel;

public interface IMyPosts
{
	public void save(MyPostsModel mypostmodel);
	public void update(int id,String Status);
	public void delete();
	public List<MyPostsModel> getAll();
	public MyPostsModel getPostById(int id);
	public List<MyPostsModel> getAllPostsByUserName(String username);
	
}