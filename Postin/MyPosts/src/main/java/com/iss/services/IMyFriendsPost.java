package com.iss.services;

import com.iss.models.MyFriendsPostModel;

interface IMyFriendsPost
{
	public void save(MyFriendsPostModel myfriendspostmodel);
	public void update();
	public void delete();
	public void getAll();
	public int getMessageById(int id);
	
}